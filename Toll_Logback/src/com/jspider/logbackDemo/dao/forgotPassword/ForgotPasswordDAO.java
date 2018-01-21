package com.jspider.logbackDemo.dao.forgotPassword;

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
public class ForgotPasswordDAO
{
	@Autowired
	private SessionFactory factory;
	
	Logger log=LoggerFactory.getLogger(ForgotPasswordDAO.class);
	
	public ForgotPasswordDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public boolean userForgotPasswordDAO(String email,String password)
	{
		log.info("ForgotPasswordDAO method started");
		
		String hql="select A.username from AdminDTO A where A.email=:em";
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try
		{
		Query qry=session.createQuery(hql);
		qry.setParameter("em",email);
		String validateEmail=(String) qry.uniqueResult();
		
		if(validateEmail!=null)
		{
			String hql2="update AdminDTO A set A.password=:pw where A.email=:em";
			
			qry=session.createQuery(hql2);
			qry.setParameter("pw",password);
			qry.setParameter("em",email);
			qry.executeUpdate();
			transaction.commit();
			
			return true;
		}
		else
		{
			System.out.println("Email Not Present");
			
			return false;
		}
		}
		catch(HibernateException e)
		{
			log.error("Exception occurred in ForgotPasswordDAO layer");
			e.printStackTrace();
			transaction.rollback();
			
		}
		finally
		{
			session.close();
		}
		
		log.info("ForgotPasswordDAO method ended");
		
		return false;
}
}
