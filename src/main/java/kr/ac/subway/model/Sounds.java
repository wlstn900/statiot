package kr.ac.subway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sounds")
public class Sounds {
	
	@Id
	private String date;
	private String place; //men_restroom,women_restroom,machine_room,substation
	private int dB;
	private boolean emergency;
	private String code;
	
	
	public Sounds(String date, String place, int dB, String code) {
		super();
		this.date = date;
		this.place = place;
		this.dB = dB;
		
		if(dB>=3000){	//특정 dB 이상이면 비상상황 true 아니면 false 로 수정
			emergency=true;
		}
		else{
			emergency=false;
		}
		
		this.code = code;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getdB() {
		return dB;
	}
	public void setdB(int dB) {
		this.dB = dB;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
