package com.jspider.logbackDemo.controller.billing;

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
import com.jspider.logbackDemo.dto.billing.BillingDTO;
import com.jspider.logbackDemo.service.billing.BillingService;

@RequestMapping("/")
@Controller
public class BillingController
{
	@Autowired
	private BillingService billingService;
	
	Logger log=LoggerFactory.getLogger(BillingController.class);
	
	public BillingController()
	{
		log.info("Created \t" + this.getClass().getSimpleName());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
	@RequestMapping(value="/billing.toll", method=RequestMethod.POST)
	public ModelAndView userBillingController(BillingDTO billingDTO,HttpServletRequest req)
	{
		log.info("BillingController method started");
		
		BillingDTO billDTO = null;
		
		try
		{
		HttpSession session = req.getSession(false);
		
		session.setAttribute("billingDTO", billingDTO);
		
		billingDTO.setTime(new Date());
		
		billingService.userBillingService(billingDTO);
		
		billDTO = (BillingDTO) session.getAttribute("billingDTO");
		}
		catch(Exception e)
		{
			log.error("Exception occurred in BillingController layer");
			e.printStackTrace();
		}
		
		log.info("BillingController method ended");
		
		return new ModelAndView("PaymentDetails.jsp","bill",billDTO);
	}

}
