package com.jspider.logbackDemo.dao.activate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActivateDAO 
{
	@Autowired
	private SessionFactory factory;
	
	Logger log=LoggerFactory.getLogger(ActivateDAO.class);
	
	public ActivateDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public int userActivateDAO(String email)
	{
		log.info("ActivateDAO method started");
		
		String hql="update AdminDTO A set A.status=:true where A.email=:em";
		
		int res = 0;
		
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try
		{
		Query qry=session.createQuery(hql);
		qry.setParameter("em", email);
		qry.setParameter("true", true);
		res=qry.executeUpdate();
		transaction.commit();
		}
		catch(HibernateException e)
		{
			log.error("Exception occured in ActivateDAO layer");
			e.printStackTrace();
			transaction.rollback();
			
		}
		finally
		{
			session.close();
		}
		
		log.info("ActivateDAO method ended");
		
		return res;
	}

}
