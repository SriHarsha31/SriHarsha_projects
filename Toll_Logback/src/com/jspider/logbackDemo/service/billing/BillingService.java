package com.jspider.logbackDemo.service.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.billing.BillingDAO;
import com.jspider.logbackDemo.dto.billing.BillingDTO;

@Service
public class BillingService 
{
	@Autowired
	private BillingDAO billingDAO;
	
	Logger log=LoggerFactory.getLogger(BillingService.class);
	
	public BillingService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public String userBillingService(BillingDTO billingDTO)
	{
		
		log.info("BillingService method started");
		
		try
		{
		boolean res = billingDAO.userBillingDAO(billingDTO);
		
		if(res == true)
		{
			return "Bill Generated";
		}
		else
		{
			return "Failed to register vehicle";
		}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in BillingService layer");
			e.printStackTrace();
		}
		
		log.info("BillingService method ended");
		
		return null;
		
	}

}
