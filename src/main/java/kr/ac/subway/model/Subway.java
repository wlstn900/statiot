package kr.ac.subway.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Subway {

	private String date;
	@NotEmpty(message="Temperature is not empty")
	private String temperature;
	@NotEmpty(message="Humidity is not empty")
	private String humidity;
	private String ultrasonic;
	private String sound1;
	private String sound2;
	private String sound3;
	private String sound4;
	
	
	public Subway() {
	
	}
	

	@Override
	public String toString() {
		return "Subway [date=" + date + ", temperature=" + temperature + ", humidity=" + humidity + ", ultrasonic=" + ultrasonic
				+ ", sounds=" + sound1 + "]";
	}



	
	public Subway(String date, String temperature, String humidity, String ultrasonic, String sound1,String sound2,
			String sound3,String sound4) {
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
		this.ultrasonic = ultrasonic;
		this.sound1 = sound1;
		this.sound2 = sound2;
		this.sound3 = sound3;
		this.sound4 = sound4;
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


	public String getSound1() {
		return sound1;
	}


	public void setSound1(String sound1) {
		this.sound1 = sound1;
	}
	
	public String getSound2() {
		return sound2;
	}


	public void setSound2(String sound2) {
		this.sound2 = sound2;
	}


	public String getSound3() {
		return sound3;
	}


	public void setSound3(String sound3) {
		this.sound3 = sound3;
	}


	public String getSound4() {
		return sound4;
	}


	public void setSound4(String sound4) {
		this.sound4 = sound4;
	}
	
	
}
