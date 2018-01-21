package com.jspider.logbackDemo.dao.billing;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspider.logbackDemo.dto.billing.BillingDTO;

@Repository
public class BillingDAO
{
	@Autowired
	private SessionFactory factory;
	
	Logger log = LoggerFactory.getLogger(BillingDAO.class);
	
	public BillingDAO()
	{
		log.info("Created \t" + this.getClass().getSimpleName());
	}
	
	public boolean userBillingDAO(BillingDTO billingDTO)
	{
		log.info("BillingDAO method started");
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try
		{
			session.save(billingDTO);
			transaction.commit();
		}
		catch(HibernateException e)
		{
			log.error("Exception occurred in BillingDAO layer");
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		
		log.info("BillingDAO method ended");
		
		return true;
	}

}
