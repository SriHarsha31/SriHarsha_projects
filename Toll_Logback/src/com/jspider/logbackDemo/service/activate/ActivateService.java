package com.jspider.logbackDemo.service.activate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.activate.ActivateDAO;

@Service
public class ActivateService
{
	@Autowired
	private ActivateDAO activateDAO;
	
	Logger log=LoggerFactory.getLogger(ActivateService.class);
	
	public ActivateService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public int userActivateService(String email)
	{
		log.info("ActivateService method started");
		

		log.info("ActivateService method ended");
		
		return activateDAO.userActivateDAO(email);
	}

}
