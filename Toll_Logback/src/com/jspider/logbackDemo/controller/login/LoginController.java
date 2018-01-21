package com.jspider.logbackDemo.controller.login;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jspider.logbackDemo.dto.admin.AdminDTO;
import com.jspider.logbackDemo.dto.login.LoginDTO;
import com.jspider.logbackDemo.service.login.LoginService;
@RequestMapping("/")
@Controller
public class LoginController 
{
	@Autowired
	private LoginService loginService;
	
	
    Logger log=LoggerFactory.getLogger(LoginController.class);
	
	public LoginController()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/login.toll", method=RequestMethod.POST)
	public ModelAndView fetchUserController(LoginDTO loginDTO, HttpServletRequest req)
	{
		log.info("LoginController method started");
		
		AdminDTO dtoFromDB = null;
		try
		{
			dtoFromDB= loginService.fetchUserService(loginDTO);
			if(dtoFromDB!=null)
			{
				if(dtoFromDB.getStatus()==true)
				{
					if(dtoFromDB.getExpiry_date().after(new Date()))
					{
						 HttpSession session = req.getSession(true);
						 session.setAttribute("adminDTO", dtoFromDB);
						 session.setAttribute("loginDTO", loginDTO);
						
						if(dtoFromDB.getRole() == true)
						{
						 return new ModelAndView("superAdminHome.jsp","msg","welcome");
						}
						else
						{
							return new ModelAndView("AdminHome.jsp","msg","welcome");
						}
						
					}
					else
					{
					
						return new ModelAndView("Login.jsp","msg","Contract Expired");
						
					}
				}
				else
				{
					return new ModelAndView("Login.jsp","msg","Please activate your account");
				}
				
			}
			else
			{
				return new ModelAndView("Login.jsp","msg","Invalid Credentials");
			}
			
		}
		catch(Exception e)
		{
			log.error("Exception occurred in LoginController layer");
			e.printStackTrace();
		}
		
		log.info("LoginController method ended");
		
		return null;
		
	}
}
