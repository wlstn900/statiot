package kr.ac.subway.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.subway.dao.SubwayDAO;
import kr.ac.subway.model.Subway;

@Service
public class SubwayService {

	private SubwayDAO subwayDao;
	
	
	@Autowired
	public void setSubwayDAO(SubwayDAO subwayDao)
	{
		this.subwayDao = subwayDao;
	}
	
	public List<Subway> getCurrent()
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
	}
}
