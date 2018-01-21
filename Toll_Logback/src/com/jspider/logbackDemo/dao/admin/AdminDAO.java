package com.jspider.logbackDemo.dao.admin;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Repository
public class AdminDAO 
{
	@Autowired
	private SessionFactory factory;

	Logger log=LoggerFactory.getLogger(AdminDAO.class);

	public AdminDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}

	public boolean saveUserDAO(AdminDTO adminDTO)
	{
		log.info("AdminDAO method started");

		String hql="select A.username from AdminDTO A where A.email=:em";
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		try
		{
			Query qry=session.createQuery(hql);
			qry.setParameter("em",adminDTO.getEmail());
			String username=(String) qry.uniqueResult();

			if(username!=null)
			{
				System.out.println("Email Already Present");
				return false;
			}
			else
			{
				session.save(adminDTO);
				transaction.commit();
				return true;
			}
		}

		catch (HibernateException e)
		{
			log.error("Exception occurred in AdminDAO layer");
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}

		log.info("AdminDAO method ended");
		
		return false;
	}

}
