package kr.ac.subway.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.subway.model.Sounds;
import kr.ac.subway.model.StationInformation;
import kr.ac.subway.model.TempAndHumid;
import kr.ac.subway.model.UltraSonic;

@Repository
@Transactional
@EnableTransactionManagement
public class SubwayDAO {

	/*
	 * private JdbcTemplate jdbcTemplateObject;
	 * 
	 * @Autowired public void setDataSourse(DataSource dataSourse) {
	 * this.jdbcTemplateObject = new JdbcTemplate(dataSourse); }
	 * 
	 * public int getRowCount() { String sqlStatement =
	 * "select count(*) from subwayinfomation";// record count
	 * 
	 * return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class); }
	 * 
	 * 
	 * public List<Subway> getSubways() { String sqlStatement =
	 * "select * from subwayinfomation";
	 * 
	 * return jdbcTemplateObject.query(sqlStatement, new SubwayMapper());
	 * 
	 * }
	 * 
	 * public boolean insert(Subway subway) { String date = subway.getDate();
	 * String temperature = subway.getTemperature(); String humidity =
	 * subway.getHumidity(); String ultrasonic = subway.getUltrasonic(); String
	 * men_rest_room_sound = subway.getMen_rest_room_sound(); String
	 * women_rest_room_sound = subway.getWomen_rest_room_sound(); String
	 * machine_room_sound = subway.getMachine_room_sound(); String
	 * substation_sound = subway.getSubstation_sound();
	 * 
	 * String sqlStatement =
	 * "insert into subwayinfomation (date, temperature, humidity, ultrasonic, men_rest_room_sound, women_rest_room_sound, machine_room_sound, substation_sound) values (?,?,?,?,?,?,?,?)"
	 * ; return (jdbcTemplateObject.update(sqlStatement, new Object[]{date,
	 * temperature, humidity, ultrasonic,
	 * men_rest_room_sound,women_rest_room_sound,machine_room_sound,
	 * substation_sound}?에 해당하는 값들임) == 1 ); }
	 * 
	 * public boolean update(Subway subway) { String date = subway.getDate();
	 * String temperature = subway.getTemperature(); String humidity =
	 * subway.getHumidity(); String ultrasonic = subway.getUltrasonic(); String
	 * men_rest_room_sound = subway.getMen_rest_room_sound(); String
	 * women_rest_room_sound = subway.getWomen_rest_room_sound(); String
	 * machine_room_sound = subway.getMachine_room_sound(); String
	 * substation_sound = subway.getSubstation_sound();
	 * 
	 * String sqlStatement =
	 * "update subwayinfomation set temperature=?, humidity=?, ultrasonic=?, men_rest_room_sound=?, women_rest_room_sound=?, machine_room_sound=?, substation_sound=? where date=?"
	 * ; return (jdbcTemplateObject.update(sqlStatement, new
	 * Object[]{temperature, humidity, ultrasonic, men_rest_room_sound,
	 * women_rest_room_sound, machine_room_sound, substation_sound, date}?에 해당하는
	 * 값들임) == 1 );//update이면 1개가 리턴이됨 }
	 * 
	 * public boolean delete(String date) { String sqlStatement =
	 * "delete from subwayinfomation where date=?"; return
	 * (jdbcTemplateObject.update(sqlStatement, new Object[]{date})==1); }
	 * 
	 * public String getTemperature() { // TODO Auto-generated method stub
	 * String sqlStatement = "select * from temper_humid"; return null; }
	 */
	@Autowired
	private SessionFactory sessionFactory;

	// 온도 습도를 DB에서 가져와 List에 저장
	@SuppressWarnings("unchecked")
	public List<TempAndHumid> getTempAndHumid() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TempAndHumid");

		List<TempAndHumid> TempAndHumidList = query.list();

		return TempAndHumidList;
	}

	// Sounds를 DB에서 가져와 List에 저장
	@SuppressWarnings("unchecked")
	public List<Sounds> getSounds() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Sounds");

		List<Sounds> SoundsList = query.list();

		return SoundsList;
	}

	// 휴지 잔여량을 DB에서 가져와 List에 저장
	@SuppressWarnings("unchecked")
	public List<UltraSonic> getUltraSonic() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UltraSonic");

		List<UltraSonic> UltraSonicList = query.list();

		return UltraSonicList;
	}

	public void addSounds(Sounds sounds) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sounds);
		session.flush();
	}

	public void addTempAndHumid(TempAndHumid tempAndHumid) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(tempAndHumid);
		session.flush();
	}

	public void addUltraSonic(UltraSonic ultraSonic) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ultraSonic);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public List<StationInformation> getCode(String stationName) {
		Session session = sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from StationInformation where name='"+stationName+"'");

		//Query query = session.createQuery("from StationInformation");
		

		List<StationInformation> stationInformations = query.list();

		return stationInformations;
		
		/*
		 * List<Integer>
		 * 
		 * code=query.list(); return code;
		 */
	}


	public List<TempAndHumid> getOtherStationInformation(String code) {
		Session session = sessionFactory.getCurrentSession();
		 Query query=session.createQuery("from TempAndHumid where code ="+code);
		 
		 List<TempAndHumid> TempAndHumids = query.list();
		 //query.setString("code", code);
		 System.out.println("DAO 부분 ");
		 //return (TempAndHumid)query.uniqueResult();
		 return TempAndHumids;
	}

}
