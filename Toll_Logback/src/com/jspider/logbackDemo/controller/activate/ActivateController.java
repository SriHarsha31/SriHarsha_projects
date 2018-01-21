package com.jspider.logbackDemo.controller.activate;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jspider.logbackDemo.service.activate.ActivateService;

@RequestMapping("/")
@Controller
public class ActivateController 
{
	@Autowired
	private ActivateService activateService;
	
	Logger log=LoggerFactory.getLogger(ActivateController.class);
	
	public ActivateController()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/adminActivate.toll", method=RequestMethod.GET)
	public  ModelAndView userActivateController(HttpServletRequest req)
	{
		
		log.info("ActivateController method started");
		
		String email=req.getParameter("em");
		
		try
		{
		activateService.userActivateService(email);
		}
		catch(Exception e)
		{
			log.error("Exception occurred in ActivateController layer");
			e.printStackTrace();
		}
		
		log.info("ActivateController method ended");
		
		return new ModelAndView("Login.jsp","msg","Account activated");
			
	}

}
