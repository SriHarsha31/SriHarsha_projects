package com.jspider.logbackDemo.service.admin;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.admin.AdminDAO;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Service
public class AdminService
{
	
	@Autowired
	private AdminDAO adminDAO;

	@Autowired
	private MailSender sender;
	
	Logger log = LoggerFactory.getLogger(AdminService.class);

	public void setSender(MailSender sender)
	{
		this.sender = sender;
	}

	public AdminService()
	{
		log.info("Created \t" + this.getClass().getSimpleName());
	}

	public String saveUserService(AdminDTO adminDTO)
	{
		log.info("AdminService method started");

		//Password Generator
		CharSequence uuid = UUID.randomUUID().toString().subSequence(0, 8);

		adminDTO.setPassword((String) uuid);
		try 
		{
			boolean res = adminDAO.saveUserDAO(adminDTO);

			if (res)
			{
				//Mail Module
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(adminDTO.getEmail());
				mailMessage.setSubject("Admin Creation Success");
				mailMessage.setText("Hi " + adminDTO.getUsername() + "\n\n"
						+ "Your Details are successfully registered with Toll Management"
						+ "Click link to Activate your Account \n"
						+ "http://localhost:80/Toll_Logback/adminActivate.toll?em=" + adminDTO.getEmail()
						+ "\n Your Credentials: \n" + "Username: " + adminDTO.getUsername() + "\n" + "password: "
						+ adminDTO.getPassword());

				sender.send(mailMessage);

				return "Registration Success";

			}
			else
			{
				return "Email already exists";
			}
		} 
		catch (Exception e)
		{
			log.error("Exception occurred in AdminService layer");
			e.printStackTrace();
		}

		log.info("AdminService method ended");
		
		return null;
	}

}
