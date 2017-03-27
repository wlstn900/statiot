package kr.ac.subway.controller;

import java.util.HashMap;
import java.util.Map;

public class LoginValue {

	private static Login login;
	private static final LoginValue instance = new LoginValue();
	
	private LoginValue()
	{
		login = new Login("admin", "1234");
	}
	
	public static LoginValue getInstance()
	{
		return instance;
	}
	
	public boolean FindValue(String id)
	{
		if(login.id.equals(id))
			return true;
		else
			return false;
	}
	
}
