package kr.ac.subway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.subway.model.StationInformation;
import kr.ac.subway.model.TempAndHumid;
import kr.ac.subway.service.SubwayService;

@RestController
public class RESTController {
	
	@Autowired
	private SubwayService subwayService;
	@RequestMapping(value = "/otherInfo")
    public void getOtherStationInfo()
    {
		
    }
	
	@RequestMapping(value = "/otherInfo/{stationName}",method = RequestMethod.GET)
    public ResponseEntity<TempAndHumid> getCodeStationInfo (@PathVariable("stationName")String stationName)
    {
		
		System.out.println("�����" + stationName);
		
		List<StationInformation> codeList = subwayService.getCode(stationName);
		String code=codeList.get(0).getCode();
		System.out.println("code : "+code);
		
		TempAndHumid tempAndHumid=subwayService.getOtherStationInformation(code).get(0);
		//�̺κ��� �ȸ����°� ����
		System.out.println("Controller ������ �κ� ����");
		System.out.println("��¥ : "+tempAndHumid.getDate());
		System.out.println("�µ� : "+tempAndHumid.getTemperature());
		System.out.println("���� : "+tempAndHumid.getHumidity());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		return new ResponseEntity<TempAndHumid>(tempAndHumid,headers,HttpStatus.OK);
		
    }
}
