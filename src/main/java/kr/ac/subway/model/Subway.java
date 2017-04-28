package kr.ac.subway.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Subway {

	private String date;
	@NotEmpty(message="Temperature is not empty")
	private String temperature;
	@NotEmpty(message="Humidity is not empty")
	private String humidity;
	private String ultrasonic;
	private String men_rest_room_sound;
	private String women_rest_room_sound;
	private String machine_room_sound;
	private String substation_sound;
	
	
	public Subway() {
	
	}

	
	@Override
	public String toString() {
		return "Subway [date=" + date + ", temperature=" + temperature + ", humidity=" + humidity + ", ultrasonic="
				+ ultrasonic + ", men_rest_room_sound=" + men_rest_room_sound + ", women_rest_room_sound="
				+ women_rest_room_sound + ", machine_room_sound=" + machine_room_sound + ", substation_sound="
				+ substation_sound + "]";
	}






	public Subway(String date, String temperature, String humidity, String ultrasonic, String men_rest_room_sound,String women_rest_room_sound,
			String machine_room_sound,String substation_sound) {
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
		this.ultrasonic = ultrasonic;
		this.men_rest_room_sound = men_rest_room_sound;
		this.women_rest_room_sound = women_rest_room_sound;
		this.machine_room_sound = machine_room_sound;
		this.substation_sound = substation_sound;
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


	public String getMen_rest_room_sound() {
		return men_rest_room_sound;
	}


	public void setMen_rest_room_sound(String men_rest_room_sound) {
		this.men_rest_room_sound = men_rest_room_sound;
	}


	public String getWomen_rest_room_sound() {
		return women_rest_room_sound;
	}


	public void setWomen_rest_room_sound(String women_rest_room_sound) {
		this.women_rest_room_sound = women_rest_room_sound;
	}


	public String getMachine_room_sound() {
		return machine_room_sound;
	}


	public void setMachine_room_sound(String machine_room_sound) {
		this.machine_room_sound = machine_room_sound;
	}


	public String getSubstation_sound() {
		return substation_sound;
	}


	public void setSubstation_sound(String substation_sound) {
		this.substation_sound = substation_sound;
	}


	
}
