package com.jspider.logbackDemo.controller.forgotPassword;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jspider.logbackDemo.dto.admin.AdminDTO;
import com.jspider.logbackDemo.service.forgotPassword.ForgotPasswordService;

@RequestMapping("/")
@Controller
public class ForgotPasswordController 
{
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	Logger log=LoggerFactory.getLogger(ForgotPasswordController.class);
	
	
	public ForgotPasswordController()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/fp.toll", method=RequestMethod.POST)
	public ModelAndView userForgotPasswordController(HttpServletRequest req, AdminDTO adminDTO )
	{
		
		log.info("ForgotPasswordController method started");
		
		try
		{
		String email=req.getParameter("email");
		
		boolean res=forgotPasswordService.userForgotPasswordMailService(email,adminDTO);
		
		if(res==true)
		{
			return new ModelAndView("Login.jsp","msg","Password Reset Successful please check your mail");
		}
		else
		{
			return new ModelAndView("ForgotPassword.jsp","msg","Email Not Present");
		}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in ForgotPasswordController layer");
			e.printStackTrace();
		}
		
		log.info("ForgotPasswordController method ended");
		
		return new ModelAndView("ForgotPassword.jsp","msg","Email Id not valid");
	}

}
