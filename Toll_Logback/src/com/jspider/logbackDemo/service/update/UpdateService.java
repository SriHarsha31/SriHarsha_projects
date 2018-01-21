package com.jspider.logbackDemo.service.update;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.update.UpdateDAO;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Service
public class UpdateService 
{
	@Autowired
	private UpdateDAO updateDAO; 
	
	Logger log=LoggerFactory.getLogger(UpdateService.class);
	
	public UpdateService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public AdminDTO userUpdateService(AdminDTO adminDTO)
	{
		log.info("UpdateService method started");
		
		try
		{
		AdminDTO dtoFromDB = updateDAO.userUpdateDAO(adminDTO);
		return dtoFromDB;
		}
		catch(Exception e)
		{
			log.error("Exception occurred in UpdateService layer");
			e.printStackTrace();
		}
		
		log.info("UpdateService method ended");
		
		return null;
	}

}
