package com.jspider.logbackDemo.dto.login;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDTO implements Serializable
{
	private String username;
	private String password;
	
	private static Logger log=LoggerFactory.getLogger(LoginDTO.class);
	
	public LoginDTO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		LoginDTO.log = log;
	}

	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}

}
