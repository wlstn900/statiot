package kr.ac.subway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tempAndHumid")
public class TempAndHumid {
	@Id
	private String date;
	private String temperature;
	private String humidity;
	private String code;//¿ª ÄÚµå  foreign key
	
	
	public TempAndHumid() {
		super();
	}

	public TempAndHumid(String date, String temperature, String humidity, String code) {
		super();
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
		this.code = code;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
