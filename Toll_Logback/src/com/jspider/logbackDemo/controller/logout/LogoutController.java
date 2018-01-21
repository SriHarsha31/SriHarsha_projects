package com.jspider.logbackDemo.controller.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LogoutController
{
	Logger log=LoggerFactory.getLogger(LogoutController.class);
	
	public LogoutController()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/logout.toll",method= RequestMethod.POST)
	public ModelAndView userLogoutController(HttpServletRequest req)
	{
		log.info("LogoutController method started");
		
		try
		{
		    HttpSession session = req.getSession(false);
		    session.invalidate();
		   // session.setMaxInactiveInterval(1);
		    //session.removeAttribute("adminDTO");
		}
		catch(Exception e)
		{
			log.error("Exception occurred in LogoutController layer");
			e.printStackTrace();
		}
		
		log.info("LogoutController method ended");
		
		return new ModelAndView("Login.jsp","msg","Logged out");
	}
}
