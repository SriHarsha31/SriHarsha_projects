package com.jspider.logbackDemo.dao.search;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Repository
public class SearchDAO
{
	@Autowired
	private SessionFactory factory;
	
	Logger log=LoggerFactory.getLogger(SearchDAO.class);
	
	public SearchDAO()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public List<AdminDTO> userSearchDAO(String username, String email, String tollName)
	{
		log.info("SearchDAO method started");
		
		String hql = "from AdminDTO A where A.username=:un or A.email=:em or A.tollbooth_name=:tn";
		
		List<AdminDTO> list = null;
		
		Session session = factory.openSession();
		try
		{
		Query qry = session.createQuery(hql);
		qry.setParameter("un", username);
		qry.setParameter("em", email);
		qry.setParameter("tn", tollName);
		list = (List<AdminDTO>) qry.list();
		}
		catch(HibernateException e)
		{
			log.error("Exception occurred in SearchDAO layer");
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		log.info("SearchDAO method ended");
		
		return list;
		
	}
}
