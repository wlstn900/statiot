package kr.ac.subway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ultraSonic")
public class UltraSonic {
	@Id
	private String date;
	private String ultraSonic;
	private String sex;
	private String code;//¿ª ÄÚµå  foreign key
	
	
	public UltraSonic() {
		super();
	}


	public UltraSonic(String date, String ultraSonic, String sex, String code) {
		super();
		this.date = date;
		this.ultraSonic = ultraSonic;
		this.sex=sex;
		this.code = code;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getUltraSonic() {
		return ultraSonic;
	}


	public void setUltraSonic(String ultraSonic) {
		this.ultraSonic = ultraSonic;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	
	
}
