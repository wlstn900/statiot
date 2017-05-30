package kr.ac.subway.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.subway.model.Sounds;
import kr.ac.subway.model.TempAndHumid;
import kr.ac.subway.model.UltraSonic_Men;
import kr.ac.subway.model.UltraSonic_Women;
import kr.ac.subway.model.User;
import kr.ac.subway.service.SubwayService;

@Controller
public class SubwayController {

	private String temperature = "";
	private String humidity = "";
	private String ultrasonic = "";
	private String code="";
	
	private SubwayService service;
	private String url = "https://fcm.googleapis.com/fcm/send"; 
	private String message = "\"������\"}";//"\"������\"}"
	private String parameters = "{\"data\": {"+"\"message\":"+message+",\"to\":\"/topics/notice\"}";
	@Autowired
	public void setSubwayService(SubwayService service) {
		this.service = service;
	}

	
	
	//�Ƶ��̳뿡�� ���� �½��� �����͸� �����ϴ� �޼ҵ� 
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
		code=request.getParameter("code").toString();	//����ö �� �ڵ尪 -> �Ƶ��̳뿡 �߰��ؾ��� ex) 409 = ����� �ΰ�ó�� 
		
		//�׽�Ʈ������ �ܼ�â�� ����ִ� ����
		System.out.println("�µ� ���� �׽�Ʈ");
		System.out.println("��¥ : "+date);
		System.out.println("�µ� : "+temperature);
		System.out.println("���� : "+humidity);
		System.out.println("code :"+code);
		
		//��ü ������ db�� ����
		TempAndHumid tempAndHumid=new TempAndHumid(date,temperature,humidity,code);
		service.addTempAndHumid(tempAndHumid);
		
	}
	
	//�Ƶ��̳뿡�� ���� ���� �ܿ��� �����͸� �����ϴ� �޼ҵ� 
	@RequestMapping(value = "/ultrasonic_men", method = RequestMethod.GET)
	public void Fetch_UltraSonic_men(HttpServletRequest request, HttpServletResponse response)
	
	{
		Date dateup = new Date();
		String date = dateup.toString();
		
		ultrasonic = request.getParameter("ultrasonic").toString();
		code=request.getParameter("code").toString();	//����ö �� �ڵ尪 -> �Ƶ��̳뿡 �߰��ؾ��� ex) 409 = ����� �ΰ�ó�� 
		
		//�׽�Ʈ������ �ܼ�â�� ����ִ� ����
		System.out.println("�� ȭ��� �ܿ��� �׽�Ʈ");
		System.out.println("��¥ : "+date);
		System.out.println("����ġ : "+ultrasonic);		//���� % ȭ �Ұ�
		// ������� /�ִ����(maxLength) * 100 �� ���� ��ġȭ -> �ִ���� �̸� ���� �ʿ�
		System.out.println("code :"+code);
		
		//��ü ������ db�� ����
		UltraSonic_Men ultraSonic_men=new UltraSonic_Men(date, ultrasonic, code);
		service.addUltraSonic_men(ultraSonic_men);
	}
	
	//�Ƶ��̳뿡�� ���� ���� �ܿ��� �����͸� �����ϴ� �޼ҵ� 
		@RequestMapping(value = "/ultrasonic_women", method = RequestMethod.GET)
		public void Fetch_UltraSonic_women(HttpServletRequest request, HttpServletResponse response)
		
		{
			Date dateup = new Date();
			String date = dateup.toString();
			
			//������ ���� �ΰ��� �Ҳ��� �ϳ��� ���ڿ� �ٸ��ϳ��� ���ڿ����� sex���� �ȿ� male , female �־ ����, ���� ȭ��� ����
			
			ultrasonic = request.getParameter("ultrasonic").toString();
			code=request.getParameter("code").toString();	//����ö �� �ڵ尪 -> �Ƶ��̳뿡 �߰��ؾ��� ex) 409 = ����� �ΰ�ó�� 
			
			//�׽�Ʈ������ �ܼ�â�� ����ִ� ����
			System.out.println("�� ȭ��� �ܿ��� �׽�Ʈ");
			System.out.println("��¥ : "+date);
			System.out.println("����ġ : "+ultrasonic);		//���� % ȭ �Ұ�
			// ������� /�ִ����(maxLength) * 100 �� ���� ��ġȭ -> �ִ���� �̸� ���� �ʿ�
			System.out.println("code :"+code);
			
			//��ü ������ db�� ����
			UltraSonic_Women ultraSonic_Women=new UltraSonic_Women(date,ultrasonic,code);
			service.addUltraSonic_women(ultraSonic_Women);
		}
		
	
	//�Ҹ� ���� �����Ͱ��� �����ϴ� �޼ҵ�
	@RequestMapping(value = "/sounds", method = RequestMethod.GET)
	public String Fetch_Sounds(HttpServletRequest request, HttpServletResponse response) {
		   
		Date dateup = new Date();
		String date = dateup.toString();
		
		String place = request.getParameter("place").toString();
		//double dB=Double.parseDouble(request.getParameter("dB").toString());
		String dB=request.getParameter("dB").toString();
		code=request.getParameter("code").toString();
		boolean emergency=false;
		
		System.out.println("��Һ� �Ҹ����� �׽�Ʈ");
		System.out.println("��¥ : "+date);
		System.out.println("��ġ : "+place);
		System.out.println("dB�� : "+dB);		//���� %ȭ �Ұ�
		System.out.println("code :"+code);
		
		if(Integer.parseInt(dB)>=100)
		{//dB�� 100���� ū ���
			
			if(place.equals("ȭ���"))
			{
				//message = "\"ȭ���\"}";
				//�׽�Ʈ������ �ܼ�â�� ����ִ� ����
				System.out.println("��Һ� �Ҹ����� �׽�Ʈ");
				System.out.println("��¥ : "+date);
				System.out.println("��ġ : "+place);
				System.out.println("dB�� : "+dB);		//���� %ȭ �Ұ�
				System.out.println("code :"+code);
				
				//��ü ������ db�� ����
				//Sounds sounds =new Sounds(date,"ȭ���",dB,code,emergency);
				//service.addSounds(sounds);
				
				return "redirect:/subway";
				
			}
			else if(place.equals("����"))
			{
				//message = "\"����\"}";
				//�׽�Ʈ������ �ܼ�â�� ����ִ� ����
				System.out.println("��Һ� �Ҹ����� �׽�Ʈ");
				System.out.println("��¥ : "+date);
				System.out.println("��ġ : "+place);
				System.out.println("dB�� : "+dB);		//���� %ȭ �Ұ�
				System.out.println("code :"+code);
				
				//��ü ������ db�� ����
				//Sounds sounds =new Sounds(date,place,dB,code,emergency);
				//service.addSounds(sounds);
				
				return "redirect:/subway";
			}
			//��Ұ� toilet���� machine���� Ȯ�� �ϱ�
			try {
				String result = sendPost(url,parameters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	//�׽�Ʈ������ �ּ� �Ű� ��������
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
		System.out.println("���� �µ� : " + temperature);
		System.out.println("���� ���� : " + humidity);
		System.out.println("���� �ð� : " + date);
		System.out.println("���� ������ : " + ultrasonic);
		System.out.println("���� ���� ȭ��� �Ҹ�: " + men_rest_room_sound);//����
		System.out.println("���� ���� ȭ��� �Ҹ�: " + women_rest_room_sound);//����
		System.out.println("���� ���� �Ҹ�: " + machine_room_sound);//����
		System.out.println("���� ������ �Ҹ�: " + substation_sound);//����
		
	}*/

	
	
	@RequestMapping("/subway")		//Ŭ���̾�Ʈ ��û�� �޾� ����ö ���������͸� DB�κ��� ������ ������
									//Front-End �κп��� ���� �������־����!
	public String SubwayMangement(Model model)
	{
		 int []placeFlag={0,0,0}; // index 0 : ȭ���, 1 : ������ , 2: ����
		
		/* User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 System.out.println("username = " + user.getUsername());*/

		 //�µ� ������ �ֽ� 5���� �׷��� �׸� �� �ֵ����Ѵ�.
		 List<TempAndHumid> tempAndHumidList = service.getTempAndHumid("409");
		 for(int i=tempAndHumidList.size()-1;i>tempAndHumidList.size()-6;i--){
			 model.addAttribute("tempAndHumid"+((tempAndHumidList.size()-1)-i), tempAndHumidList.get(i));
		 }
		 
		 
		 List<Sounds> soundList = service.getSounds();
		 
		 for(int i=soundList.size()-1;i>=0;i--){
			 if(soundList.get(i).getPlace().equals("ȭ���")&&placeFlag[0]==0){
				 placeFlag[0]=1;
				 model.addAttribute("sound0",soundList.get(i).getdB());
			 }
			 
			 else if(soundList.get(i).getPlace().equals("������")&&placeFlag[1]==0){
				 placeFlag[1]=1;
				 model.addAttribute("sound1",soundList.get(i).getdB());
			 }
			 
			 
			 else if(soundList.get(i).getPlace().equals("����")&&placeFlag[2]==0){
				 placeFlag[2]=1;
				 model.addAttribute("sound2",soundList.get(i).getdB());
			 }
			 
			 if(placeFlag[0]==1&&placeFlag[1]==1&&placeFlag[2]==1){
				 break;
			 }
		 }
		 

		 List<UltraSonic_Men> ultraSonicListForMen = service.getUltraSonicForMen();
		 model.addAttribute("ultraSonic_men", Integer.parseInt(ultraSonicListForMen.get(0).getUltraSonic()));
		 
		 List<UltraSonic_Women> ultraSonicListForWomen = service.getUltraSonicForWomen();
		 model.addAttribute("ultraSonic_women", Integer.parseInt(ultraSonicListForWomen.get(0).getUltraSonic()));
		 
		 return "subway";
	}
	@RequestMapping("/discomfortindex")//��������
	public String discomfortindex(Model model)
	{
		List<TempAndHumid> tempAndHumidList = service.getTempAndHumid("409");
		double Ta=Double.parseDouble(tempAndHumidList.get(tempAndHumidList.size()-1).getTemperature());
		double RH=Double.parseDouble(tempAndHumidList.get(tempAndHumidList.size()-1).getHumidity());
		RH=RH/100.0;
		double DI = (double) ((9/5.0)*Ta - 0.55*(1 - RH)*((9 /5.0)*Ta - 26) + 32);
		model.addAttribute("DI",DI);
		 return "discomfortindex";
	}
	
	@RequestMapping("/survey")//��������κ� �ʿ� x ���� �߰� ����
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
