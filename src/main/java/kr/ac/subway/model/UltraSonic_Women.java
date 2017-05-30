package kr.ac.subway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ultrasonic_women")
public class UltraSonic_Women {

	@Id
	private String date;
	private String ultraSonic;
	private String code;// ¿ª ÄÚµå foreign key

	public UltraSonic_Women() {
		super();
	}

	public UltraSonic_Women(String date, String ultraSonic, String code) {
		super();
		this.date = date;
		this.ultraSonic = ultraSonic;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
