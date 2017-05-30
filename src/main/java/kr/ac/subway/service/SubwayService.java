package kr.ac.subway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.subway.dao.SubwayDAO;
import kr.ac.subway.model.Sounds;
import kr.ac.subway.model.StationInformation;
import kr.ac.subway.model.TempAndHumid;
import kr.ac.subway.model.UltraSonic_Men;
import kr.ac.subway.model.UltraSonic_Women;

@Service
public class SubwayService {

	private SubwayDAO subwayDao;
	
	
	@Autowired
	public void setSubwayDAO(SubwayDAO subwayDao)
	{
		this.subwayDao = subwayDao;
	}
	
	/*public List<Subway> getCurrent()
	{
		return subwayDao.getSubways();
	}
	
	public void insert(Subway subway)
	{
		subwayDao.insert(subway);
	}

	public String getTemperature() {
		// TODO Auto-generated method stub
		return subwayDao.getTemperature();
	}*/
	
	public List<TempAndHumid> getTempAndHumid(String code)
	{
		return subwayDao.getTempAndHumid(code);
	}
	

	public List<Sounds> getSounds()
	{
		return subwayDao.getSounds();
	}
	
	
	public List<UltraSonic_Men> getUltraSonicForMen()
	{
		return subwayDao.getUltraSonicForMen();
	}
	
	public List<UltraSonic_Women> getUltraSonicForWomen()
	{
		return subwayDao.getUltraSonicForWomen();
	}
	
	public void addSounds(Sounds sounds)
	{
		subwayDao.addSounds(sounds);
	}
	
	public void addTempAndHumid(TempAndHumid tempAndHumid)	{
		subwayDao.addTempAndHumid(tempAndHumid);
	}
	
	public void addUltraSonic_men(UltraSonic_Men ultraSonic)	{
		subwayDao.addUltraSonic_men(ultraSonic);
	}
	
	public void addUltraSonic_women(UltraSonic_Women ultraSonic)	{
		subwayDao.addUltraSonic_women(ultraSonic);
	}
	
	public List<StationInformation> getCode(String stationName){
		return subwayDao.getCode(stationName);
	}
	
	public List<TempAndHumid> getOtherStationInformation(String code){
		System.out.println("Service �κ� ����");
		return subwayDao.getOtherStationInformation(code);
	}
	
}
