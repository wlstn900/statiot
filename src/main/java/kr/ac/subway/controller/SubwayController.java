package kr.ac.subway.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.subway.model.Sounds;
import kr.ac.subway.model.TempAndHumid;
import kr.ac.subway.model.UltraSonic;
import kr.ac.subway.service.SubwayService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SubwayController {

	private String temperature = "";
	private String humidity = "";
	private String ultrasonic = "";
	private String code="";
	
	private SubwayService service;
	private String url = "https://fcm.googleapis.com/fcm/send"; 
	private String message = "\"변전실\"}";//"\"변전실\"}"
	//String parameters = "{"+ "\"data\": {"+ "\"message\": \"test\""+"},"+ "\"to\": \"/topics/notice\""+"}"; 
	private String parameters = "{\"data\": {"+"\"message\":"+message+",\"to\":\"/topics/notice\"}";
	@Autowired
	public void setSubwayService(SubwayService service) {
		this.service = service;
	}

	
	
	//아두이노에서 받은 온습도 데이터를 저장하는 메소드 
	@RequestMapping(value = "/tempHumid", method = RequestMethod.GET
			/*headers="content-type=application/x-www-form-urlencoded"*/)
	public void Fetch_Temperate(HttpServletRequest request, HttpServletResponse response)			// throws
																									// ServletException,
																									// IOException
		{
		Date dateup = new Date();
		String date = dateup.toString();
		temperature = request.getParameter("temperature").toString();
		humidity = request.getParameter("humidity").toString();
		code=request.getParameter("code").toString();	//지하철 역 코드값 -> 아두이노에 추가해야함 ex) 409 = 당고개역 인것처럼 
		
		//테스트용으로 콘솔창에 찍어주는 역할
		System.out.println("온도 습도 테스트");
		System.out.println("날짜 : "+date);
		System.out.println("온도 : "+temperature);
		System.out.println("습도 : "+humidity);
		System.out.println("code :"+code);
		
		//객체 생성후 db에 저장
		TempAndHumid tempAndHumid=new TempAndHumid(date,temperature,humidity,code);
		service.addTempAndHumid(tempAndHumid);
		
	}
	
	//아두이노에서 받은 휴지 잔여량 데이터를 저장하는 메소드 
	@RequestMapping(value = "/ultraSonic", method = RequestMethod.GET)
	public void Fetch_UltraSonic(HttpServletRequest request, HttpServletResponse response)
	
	{
		Date dateup = new Date();
		String date = dateup.toString();
		
		//초음파 센서 두개로 할껀데 하나는 여자용 다른하나는 남자용으로 sex변수 안에 male , female 넣어서 남자, 여자 화장실 구분
		String sex=request.getParameter("sex").toString();
		ultrasonic = request.getParameter("ultrasonic").toString();
		code=request.getParameter("code").toString();	//지하철 역 코드값 -> 아두이노에 추가해야함 ex) 409 = 당고개역 인것처럼 
		
		//테스트용으로 콘솔창에 찍어주는 역할
		System.out.println("남,여 화장실 잔여량 테스트");
		System.out.println("날짜 : "+date);
		System.out.println("성별 : "+sex);
		System.out.println("측정치 : "+ultrasonic);		//추후 % 화 할것
		System.out.println("code :"+code);
		
		
		
		//객체 생성후 db에 저장
		UltraSonic ultraSonic=new UltraSonic(date,sex,ultrasonic,code);
		service.addUltraSonic(ultraSonic);
	}
	
	//소리 감지 데이터값을 저장하는 메소드
	@RequestMapping(value = "/sounds", method = RequestMethod.GET)
	public void Fetch_Sounds(HttpServletRequest request, HttpServletResponse response) {
		
		Date dateup = new Date();
		String date = dateup.toString();
		
		String place = request.getParameter("place").toString();
		int dB=Integer.parseInt(request.getParameter("dB"));
		code=request.getParameter("code").toString();
		
		
		if(dB>=100)
		{//dB가 100보다 큰 경우
			if(place.equals("toilet"))
			{
				message = "\"화장실\"}";
			}
			else if(place.equals("machine"))
			{
				message = "\"기계실\"}";
			}
			//장소가 toilet인지 machine인지 확인 하기
			try {
				String result = sendPost(url,parameters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//테스트용으로 콘솔창에 찍어주는 역할
			System.out.println("장소별 소리감지 테스트");
			System.out.println("날짜 : "+date);
			System.out.println("위치 : "+place);
			System.out.println("dB값 : "+dB);		//추후 %화 할것
			System.out.println("code :"+code);
		
		}
		
		//객체 생성후 db에 저장
		Sounds sounds =new Sounds(date,place,dB,code);
		service.addSounds(sounds);
		
	}

	//테스트용으로 주석 신경 쓰지말것
	/*public void printer(Model model) {
		Date dateup = new Date();
		String date = dateup.toString();
		
		Sounds sounds = new Sounds(date, men_rest_room_sound, women_rest_room_sound, machine_room_sound, substation_sound, code)
		if (!(temperature=="") && !(humidity=="") && !(ultrasonic=="")
				&& !(men_rest_room_sound=="") && !(women_rest_room_sound=="") && !(machine_room_sound=="") && !(substation_sound=="")) {
			 Subway subway = new Subway(date, temperature, humidity, ultrasonic, men_rest_room_sound, women_rest_room_sound, machine_room_sound, substation_sound);
			 
			 service.addSounds(sounds);
			
			 
			 //request.setAttribute("subwayInfo" , subwayInfo);
			
		}
		System.out.println("현재 온도 : " + temperature);
		System.out.println("현재 습도 : " + humidity);
		System.out.println("현재 시간 : " + date);
		System.out.println("현재 초음파 : " + ultrasonic);
		System.out.println("현재 남자 화장실 소리: " + men_rest_room_sound);//변경
		System.out.println("현재 여자 화장실 소리: " + women_rest_room_sound);//변경
		System.out.println("현재 기계실 소리: " + machine_room_sound);//변경
		System.out.println("현재 변전실 소리: " + substation_sound);//변경
		
	}*/

	
	
	@RequestMapping("/subway")		//클라이언트 요청을 받아 지하철 정보데이터를 DB로부터 가져와 보내줌
									//Front-End 부분에서 변수 수정해주어야함!
	public String SubwayMangement(Model model)
	{
		
		//온도 측정값 최신 5개로 그래프 그릴 수 있도록한다.
		 List<TempAndHumid> tempAndHumidList = service.getTempAndHumid();
		 for(int i=0;i<5;i++){
			 model.addAttribute("tempAndHumid"+i, tempAndHumidList.get(i));
		 }
		 
		 
		 List<Sounds> soundList = service.getSounds();
		 //model.addAttribute("soundList", soundList.get(0));
		 for(int i=0;i<5;i++){
			 //model.addAttribute("soundList"+i, soundList.get(i));
		 }
		 
		 List<UltraSonic> ultraSonicList = service.getUltraSonic();
		 
		 for(int i=0;i<10;i++){
			 if(ultraSonicList.get(i).getSex().equals("male"))
			 {
				 model.addAttribute("ultraSonic_male", Integer.parseInt(ultraSonicList.get(i).getUltraSonic()));
			 }
			 else{
				 model.addAttribute("ultraSonic_female", Integer.parseInt(ultraSonicList.get(i).getUltraSonic()));
			 }
			 //model.addAttribute("soundList"+i, soundList.get(i));
		 }
		 //model.addAttribute("ultraSonic",ultraSonicList.get(0));
		 //수정작업
		 //String temperature=service.getTemperature();
		
		 return "subway";
	}
	
	@RequestMapping("/survey")//설문조사부분 필요 x 추후 추가 예정
	public String survey(Model model)
	{
		 return "survey";
	}
	
	public String sendPost(String url, String parameters) throws Exception { 
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
                public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
                public void checkClientTrusted(X509Certificate[] certs, String authType){}
                public void checkServerTrusted(X509Certificate[] certs, String authType){}
        }};
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
   
       URL obj = new URL(url);
       HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
   
       //reuqest header
       con.setRequestMethod("POST");
       con.setRequestProperty("Content-Type", "application/json");
       con.setRequestProperty("Authorization", "key= AAAA6Nz5EqM:APA91bFC3h1KtQeFu3KV2cZzWxEPwL0LFF-61lnsZ6bV5WO_VzGx17iG_m1Q1RghZMtuPXKChQYnffRCpNBl8LQxPExr13I0FDHLY28JAyxE7msA6JISoxX_CnEEnSCforfi0BmVlT6c ");
       String urlParameters = parameters;
   
       //post request
       con.setDoOutput(true);
       DataOutputStream wr = new DataOutputStream(con.getOutputStream());
       wr.write(urlParameters.getBytes("UTF-8"));
       wr.flush();
       wr.close();

       int responseCode = con.getResponseCode();     
       System.out.println("Post parameters : " + urlParameters);
       System.out.println("Response Code : " + responseCode);
   
       StringBuffer response = new StringBuffer();
   
       if(responseCode == 200){   
              BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
              String inputLine;
              while ((inputLine = in.readLine()) != null) {
                     response.append(inputLine);
              }
              in.close();   
       }
       //result
       System.out.println(response.toString());
       return response.toString();
}


}
