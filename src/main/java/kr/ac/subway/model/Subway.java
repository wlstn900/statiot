package kr.ac.subway.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Subway {

	private String date;
	@NotEmpty(message="Temperature is not empty")
	private String temperature;
	@NotEmpty(message="Humidity is not empty")
	private String humidity;
	private String ultrasonic;
	private String sounds;
	
	
	public Subway() {
	
	}
	

	@Override
	public String toString() {
		return "Subway [date=" + date + ", temperature=" + temperature + ", humidity=" + humidity + ", ultrasonic=" + ultrasonic
				+ ", sounds=" + sounds + "]";
	}



	
	public Subway(String date, String temperature, String humidity, String ultrasonic, String sounds) {
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
		this.ultrasonic = ultrasonic;
		this.sounds = sounds;
	}


	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}


	public String getUltrasonic() {
		return ultrasonic;
	}


	public void setUltrasonic(String ultrasonic) {
		this.ultrasonic = ultrasonic;
	}


	public String getSounds() {
		return sounds;
	}


	public void setSounds(String sounds) {
		this.sounds = sounds;
	}
	
	
	
}
