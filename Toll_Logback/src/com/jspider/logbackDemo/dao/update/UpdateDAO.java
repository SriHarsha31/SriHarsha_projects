package com.jspider.logbackDemo.dao.update;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Repository
public class UpdateDAO 
{
	@Autowired
	private SessionFactory factory;
	
	Logger log=LoggerFactory.getLogger(UpdateDAO.class);
	
	public UpdateDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public AdminDTO userUpdateDAO(AdminDTO adminDTO)
	{
		log.info("UpdateDAO method started");
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try
		{
	    AdminDTO dtoFromDB = (AdminDTO) session.merge(adminDTO);
		transaction.commit();
		
		return dtoFromDB;
		}
		catch(HibernateException e)
		{
			log.error("Exception occurred in UpdateDAO layer");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		log.info("UpdateDAO method ended");

		return null;
	}

}
