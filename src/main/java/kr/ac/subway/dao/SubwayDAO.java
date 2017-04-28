package kr.ac.subway.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.subway.model.Subway;

@Repository
@Component
public class SubwayDAO {

	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSourse(DataSource dataSourse) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSourse);
	}

	public int getRowCount()
	{
		String sqlStatement = "select count(*) from subwayinfomation";// record count
															
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}

	
	public List<Subway> getSubways() {
		String sqlStatement = "select * from subwayinfomation";
		
		return jdbcTemplateObject.query(sqlStatement, new SubwayMapper());
		
	}
	
	public boolean insert(Subway subway)
	{
		String date = subway.getDate();
		String temperature = subway.getTemperature();
		String humidity = subway.getHumidity();
		String ultrasonic = subway.getUltrasonic();
		String men_rest_room_sound = subway.getMen_rest_room_sound();
		String women_rest_room_sound = subway.getWomen_rest_room_sound();
		String machine_room_sound = subway.getMachine_room_sound();
		String substation_sound = subway.getSubstation_sound();
		
		String sqlStatement = "insert into subwayinfomation (date, temperature, humidity, ultrasonic, men_rest_room_sound, women_rest_room_sound, machine_room_sound, substation_sound) values (?,?,?,?,?,?,?,?)"; 
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{date, temperature, humidity, ultrasonic, men_rest_room_sound,women_rest_room_sound,machine_room_sound,substation_sound}/*?에 해당하는 값들임*/) == 1 );
	}
	
	public boolean update(Subway subway)
	{
		String date = subway.getDate();
		String temperature = subway.getTemperature();
		String humidity = subway.getHumidity();
		String ultrasonic = subway.getUltrasonic();
		String men_rest_room_sound = subway.getMen_rest_room_sound();
		String women_rest_room_sound = subway.getWomen_rest_room_sound();
		String machine_room_sound = subway.getMachine_room_sound();
		String substation_sound = subway.getSubstation_sound();
		
		String sqlStatement = "update subwayinfomation set temperature=?, humidity=?, ultrasonic=?, men_rest_room_sound=?, women_rest_room_sound=?, machine_room_sound=?, substation_sound=? where date=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{temperature, humidity, ultrasonic, men_rest_room_sound, women_rest_room_sound, machine_room_sound, substation_sound, date}/*?에 해당하는 값들임*/) == 1 );//update이면 1개가 리턴이됨
	}
	
	public boolean delete(String date)
	{
		String sqlStatement = "delete from subwayinfomation where date=?";
		return (jdbcTemplateObject.update(sqlStatement, new Object[]{date})==1);
	}

	public String getTemperature() {
		// TODO Auto-generated method stub
		String sqlStatement = "select * from temper_humid";
		return null;
	}
}

