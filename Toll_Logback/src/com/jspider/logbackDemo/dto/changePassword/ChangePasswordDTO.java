package com.jspider.logbackDemo.dto.changePassword;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangePasswordDTO implements Serializable
{
	private String newPassword;
	private String confirmPassword;
	
	Logger log=LoggerFactory.getLogger(ChangePasswordDTO.class);
	
	public ChangePasswordDTO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordDTO [newPassword=" + newPassword + ", confirmPassword=" + confirmPassword + "]";
	}

}
