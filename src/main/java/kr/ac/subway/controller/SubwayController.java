package kr.ac.subway.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.subway.model.Subway;
import kr.ac.subway.service.SubwayService;

@Controller
public class SubwayController {

	private String temperature = "";
	private String humidity = "";
	private String ultrasonic = "";
	private String men_rest_room_sound= "";//남자 화장실 소리
	private String women_rest_room_sound = "";//여자 화장실 소리
	private String machine_room_sound = "";//기계실 소리
	private String substation_sound = "";//변전실 소리
	
	private SubwayService service;

	@Autowired
	public void setSubwayService(SubwayService service) {
		this.service = service;
	}

	
	@RequestMapping(value = "/tempHumid", method = RequestMethod.POST)
	public String Fetch_Temperate(HttpServletRequest request, HttpServletResponse response, Model model) // throws
																										// ServletException,
																										// //
																										// IOException
	
		{
		System.out.println("온도 습도용 프린터");
		temperature = request.getParameter("field1").toString();
		humidity = request.getParameter("field2").toString();
		// String sounds = request.getParameter("field4").toString();
		
		printer(model);
		// System.out.println("현재 소리 : " + sounds);

		// if ((!temperature.equals(null)) && (!humidity.equals(null)) &&
		// (!ultrasonic.equals(null))
		// && (!sounds.equals(null))) {
		// Subway subway = new Subway(date, temperature, humidity, ultrasonic,
		// sounds);
		// service.insert(subway);
		//
		 List<Subway> subwayInfo = service.getCurrent();
		 model.addAttribute("subwayInfo", subwayInfo);
		// // request.setAttribute("subwayInfo" , subwayInfo);
		// }
		return "subwayInfo";
		// String page="/WEB-INF/views/subwayInfo.jsp";
		// RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		// dispatcher.forward(request, response);
	}
	
	@RequestMapping(value = "/ultra", method = RequestMethod.GET)
	public String Fetch_UltraSonic(HttpServletRequest request, HttpServletResponse response, Model model) // throws
	// ServletException, // IOException
	{
		ultrasonic = request.getParameter("field3").toString();
		// String sounds = request.getParameter("field4").toString();

		printer(model);

		// System.out.println("현재 소리 : " + sounds);

		return "subwayInfo";
		// String page="/WEB-INF/views/subwayInfo.jsp";
		// RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		// dispatcher.forward(request, response);
	}

	public void printer(Model model) {
		Date dateup = new Date();
		String date = dateup.toString();

		if (!(temperature=="") && !(humidity=="") && !(ultrasonic=="")
				&& !(men_rest_room_sound=="") && !(women_rest_room_sound=="") && !(machine_room_sound=="") && !(substation_sound=="")) {
			 Subway subway = new Subway(date, temperature, humidity, ultrasonic, men_rest_room_sound, women_rest_room_sound, machine_room_sound, substation_sound);
			 service.insert(subway);
			
			 
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
		
	}

	@RequestMapping(value = "/sounds", method = RequestMethod.GET)
	public String Fetch_Sounds(HttpServletRequest request, HttpServletResponse response, Model model) {
		men_rest_room_sound = request.getParameter("field4").toString();

		printer(model);
		
		return "subway";
	}
	
	@RequestMapping("/subway")		//클라이언트 요청을 받아 지하철 정보데이터를 DB로부터 가져와 보내줌
	public String SubwayMangement(Model model)
	{
		 List<Subway> subwayInfo = service.getCurrent();
		 
		 for(int i=0;i<5;i++){
			 model.addAttribute("subwayInfo"+i, subwayInfo.get(i));
		 }
		 
		 model.addAttribute("tissue",subwayInfo.get(0));
		 //수정작업
		 //String temperature=service.getTemperature();
		
		 //
		 return "subway";
	}
	
	@RequestMapping("/survey")
	public String survey(Model model)
	{
		 return "survey";
	}

}
