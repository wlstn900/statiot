package kr.ac.subway.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.subway.model.Subway;

public class SubwayMapper implements RowMapper<Subway> {

	public Subway mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Subway subway = new Subway();
		subway.setDate(rs.getString("date"));
		subway.setTemperature(rs.getString("temperature"));
		subway.setHumidity(rs.getString("humidity"));
		subway.setUltrasonic(rs.getString("ultrasonic"));
		subway.setMen_rest_room_sound(rs.getString("men_rest_room_sound"));
		subway.setWomen_rest_room_sound(rs.getString("women_rest_room_sound"));
		subway.setMachine_room_sound(rs.getString("machine_room_sound"));
		subway.setSubstation_sound(rs.getString("substation_sound"));
		return subway;
	}

}
