package kr.ac.subway.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stationinformation")
public class StationInformation {
	@Id
	String code;
	String name;
	String tel;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public StationInformation(String code, String name, String tel) {
		super();
		this.code = code;
		this.name = name;
		this.tel = tel;
	}

	public StationInformation() {
		super();
	}

}
