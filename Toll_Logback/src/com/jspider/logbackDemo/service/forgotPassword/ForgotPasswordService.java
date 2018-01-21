package com.jspider.logbackDemo.service.forgotPassword;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.forgotPassword.ForgotPasswordDAO;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Service
public class ForgotPasswordService
{
	@Autowired
	private ForgotPasswordDAO forgotPasswordDAO;
	
	@Autowired
	private MailSender sender;
	
	Logger log=LoggerFactory.getLogger(ForgotPasswordService.class);
	
	public void setSender(MailSender sender) {
		this.sender = sender;
	}
	
	public ForgotPasswordService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	
	public boolean userForgotPasswordMailService(String email,AdminDTO adminDTO)
	{
		
		log.info("ForgotPasswordMailService method started");
		
		//Password Generator
		CharSequence uuid = UUID.randomUUID().toString().subSequence(0, 8);
		
		try
		{
		
		adminDTO.setPassword((String) uuid);
		boolean res=forgotPasswordDAO.userForgotPasswordDAO(email, adminDTO.getPassword());
		
		if(res==true)
		{
			//Mail Module
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setTo(adminDTO.getEmail());
			mailMessage.setSubject("Password Reset");
			mailMessage.setText("Hi "+"\n\n"
					+ "Your new Password is  "
					+ adminDTO.getPassword());
			
			sender.send(mailMessage);
			
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception e)
		{
			log.error("Exception occurred in ForgotPasswordService layer");
			e.printStackTrace();
		}
		
		log.info("ForgotPasswordMailService method ended");
		
		return true;
		
	}

}
