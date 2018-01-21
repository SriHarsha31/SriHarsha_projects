package com.jspider.logbackDemo.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.login.LoginDAO;
import com.jspider.logbackDemo.dto.admin.AdminDTO;
import com.jspider.logbackDemo.dto.login.LoginDTO;

@Service
public class LoginService 
{
	@Autowired
	private LoginDAO loginDAO;
	
	Logger log=LoggerFactory.getLogger(LoginService.class);
	
	public LoginService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public AdminDTO fetchUserService(LoginDTO loginDTO)
	{
		log.info("LoginService method started");
		
		AdminDTO dtoFromDB=null;
		try
		{
			dtoFromDB=loginDAO.fetchUserDAO(loginDTO);
		}
		catch (Exception e)
		{
			log.error("Exception occurred in LoginService layer");
			e.printStackTrace();
		}
		
		log.info("LoginService method ended");
		
		return dtoFromDB;
	}

}
