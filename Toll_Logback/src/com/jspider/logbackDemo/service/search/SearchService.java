package com.jspider.logbackDemo.service.search;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jspider.logbackDemo.dao.search.SearchDAO;
import com.jspider.logbackDemo.dto.admin.AdminDTO;

@Service
public class SearchService
{
	@Autowired
	private SearchDAO searchDAO;
	
	Logger log=LoggerFactory.getLogger(SearchService.class);
	
	public SearchService()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	public List userSearchService(String username, String email, String tollName)
	{
		log.info("SearchService method started");
		
		List<AdminDTO> list = null;
		try
		{
		list = searchDAO.userSearchDAO(username, email, tollName);
		}
		catch(Exception e)
		{
			log.error("Exception occurred in SearchService layer");
			e.printStackTrace();
		}
		
		log.info("SearchService method ended");
		
		return list;
	}

}
