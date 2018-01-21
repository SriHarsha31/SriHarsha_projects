package com.jspider.logbackDemo.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jspider.logbackDemo.dto.admin.AdminDTO;
import com.jspider.logbackDemo.service.admin.AdminService;

@RequestMapping("/")
@Controller
public class AdminController 
{
	@Autowired
	private AdminService adminService;

	Logger log = LoggerFactory.getLogger(AdminController.class);

	public AdminController() 
	{
		log.info("Created \t" + this.getClass().getSimpleName());
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/admin.toll", method = RequestMethod.POST)
	public ModelAndView saveUserController(AdminDTO adminDTO)
	{
		log.info("AdminController method started");
		
		try
		{
		if (adminDTO.getExpiry_date().after(new Date()))
		{
			
			adminDTO.setRole(false);
			
			String message = adminService.saveUserService(adminDTO);
			
			
			return new ModelAndView("superAdminHome.jsp", "msg", "Admin " + message);
		}
		else
		{
			return new ModelAndView("addAdmin.jsp", "msg", "Date must be greater than current date");
		}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in AdminController layer");
			e.printStackTrace();
		}
		
		log.info("AdminController method ended");
		
		return null;
	}
}
