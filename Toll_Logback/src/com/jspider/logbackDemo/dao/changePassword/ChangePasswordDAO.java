package com.jspider.logbackDemo.dao.changePassword;

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
public class ChangePasswordDAO 
{
	@Autowired
	private SessionFactory factory;
	
	Logger log=LoggerFactory.getLogger(ChangePasswordDAO.class);
	
	public ChangePasswordDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public boolean userChangePasswordDAO(String email,String password)
	{
		
		log.info("ChangePasswordDAO method started");
		
		String hql="select A.username from AdminDTO A where A.email=:em";
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try
		{
		Query qry = session.createQuery(hql);
		qry.setParameter("em", email);
		String username= (String) qry.uniqueResult();
		
		if(username!=null)
		{
			String hql2="update AdminDTO A set A.password=:pwd where A.email=:em";
			qry = session.createQuery(hql2);
			qry.setParameter("pwd", password);
			qry.setParameter("em", email);
			qry.executeUpdate();
			transaction.commit();
			
			return true;
		}
		else
		{
			System.out.println("invalid email");
			return false;
		}
		}
		catch(HibernateException e)
		{
			log.error("Exception occurred in ChangePasswordDAO layer");
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		
		log.info("ChangePasswordDAO method ended");
		
		return false;
	}

}
