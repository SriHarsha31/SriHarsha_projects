package com.jspider.logbackDemo.service.changePassword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.changePassword.ChangePasswordDAO;

@Service
public class ChangePasswordService
{
	@Autowired
	private ChangePasswordDAO changePasswordDAO;
	
	Logger log=LoggerFactory.getLogger(ChangePasswordService.class);
	
	public ChangePasswordService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public boolean userChangePasswordService(String email,String password)
	{
		log.info("ChangePasswordService method started");
		
		boolean res = false;
		try
		{
		res = changePasswordDAO.userChangePasswordDAO(email, password);
		}
		catch(Exception e)
		{
			log.error("Exception occurred in ChangePasswordService layer");
			e.printStackTrace();
		}
		
		log.info("ChangePasswordService method ended");
		
		return res;
	}

}
