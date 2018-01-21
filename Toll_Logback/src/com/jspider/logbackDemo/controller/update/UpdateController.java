package com.jspider.logbackDemo.controller.update;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.jspider.logbackDemo.service.update.UpdateService;

@Controller
@RequestMapping("/")
public class UpdateController
{
	@Autowired
	private UpdateService updateService;
	
	Logger log=LoggerFactory.getLogger(UpdateController.class);
	
	public UpdateController()
	{
		log.info("Created \t"+this.getClass().getSimpleName()); 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping(value="/update.toll", method=RequestMethod.POST)
	public ModelAndView userUpdateController(HttpServletRequest req, AdminDTO adminDTO)
	{
		
		log.info("UpdateController method started");
		try
		{
		HttpSession session = req.getSession(false);
		
		AdminDTO dtoFromSession = (AdminDTO) session.getAttribute("adminDTO");
		
		adminDTO.setId(dtoFromSession.getId());
		
		adminDTO.setExpiry_date(dtoFromSession.getExpiry_date());
		
		AdminDTO dtoFromDB = updateService.userUpdateService(adminDTO);
	    
		session.setAttribute("adminDTO", dtoFromDB);
		
	    if(adminDTO.getRole() == true)
		{
	    	return new ModelAndView("superAdminHome.jsp","msg","Details updated Successfully");	
		}
	    else
	    {
	    	return new ModelAndView("AdminHome.jsp","msg","Details updated Successfully");
		}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in UpdateController layer");
			e.printStackTrace();
		}
		
		log.info("UpdateController method ended");
		
		return null;
}
}
