package com.jspider.logbackDemo.controller.changePassword;

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
import com.jspider.logbackDemo.dto.changePassword.ChangePasswordDTO;
import com.jspider.logbackDemo.service.changePassword.ChangePasswordService;

@RequestMapping("/")
@Controller
public class ChangePasswordController 
{
	@Autowired
	private ChangePasswordService changePasswordService;
	
	Logger log=LoggerFactory.getLogger(ChangePasswordController.class);
	
	public ChangePasswordController()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/cp.toll", method=RequestMethod.POST)
	public ModelAndView userChangePasswordController(HttpServletRequest req ,ChangePasswordDTO changePasswordDTO)
	{
		
		log.info("ChangePasswordController method started");
		
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		
		HttpSession session = req.getSession(false);
		         
		AdminDTO adminDTO = (AdminDTO) session.getAttribute("adminDTO");
		String email = adminDTO.getEmail();
		
		session.setAttribute("adminDTO", adminDTO);
		
		try
		{
			
			boolean res = changePasswordService.userChangePasswordService(email, confirmPassword);
			
			session.setAttribute("password", confirmPassword);
			
			String password = (String) session.getAttribute("password");
			
			
		if(res == true)
		{
		
		if(newPassword.equals(confirmPassword))
		{
			if(adminDTO.getRole() == true)
			{
				adminDTO.setPassword(password);
				
				return new ModelAndView("superAdminHome.jsp","msg","Password has been changed");
			}
			else
			{
				adminDTO.setPassword(password);
				
			  return new ModelAndView("AdminHome.jsp","msg","Password has been changed");
			}
		}
		else
		{
			if(adminDTO.getRole() == true)
			{
				return new ModelAndView("ChangePassword.jsp","msg","Password mismatch");
			}
			else
			{
			    return new ModelAndView("ChangePassword.jsp","msg","Password mismatch");
			}
		}
		}
		else
		{
			return new ModelAndView("Login.jsp","msg","Retry operation failed");
		}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in ChangePasswordController layer");
			e.printStackTrace();
		}
		
		log.info("ChangePasswordController method ended");
		
		return null;
		
	}
}


