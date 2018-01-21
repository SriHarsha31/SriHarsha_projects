package com.jspider.logbackDemo.dao.login;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspider.logbackDemo.dto.admin.AdminDTO;
import com.jspider.logbackDemo.dto.login.LoginDTO;

@Repository
public class LoginDAO
{
	@Autowired
	private SessionFactory factory;
	
	Logger log=LoggerFactory.getLogger(LoginDAO.class);
	
	public LoginDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public AdminDTO fetchUserDAO(LoginDTO loginDTO)
	{
		log.info("LoginDAO method started");
		
		String hql="From AdminDTO A where A.username=:un and A.password=:pwd";
		Session session=null;
		AdminDTO dtoFromDB=null;
		try
		{
			session=factory.openSession();
			Query qry=session.createQuery(hql);
			qry.setParameter("un", loginDTO.getUsername());
			qry.setParameter("pwd", loginDTO.getPassword());
			dtoFromDB = (AdminDTO) qry.uniqueResult();
			
		}
		catch(HibernateException e)
		{
			log.error("Exception occurred in LoginDAO layer");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		log.info("LoginDAO method ended");
		
		return dtoFromDB;
	}

}
