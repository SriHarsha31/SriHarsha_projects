package com.jspider.logbackDemo.controller.search;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.jspider.logbackDemo.dto.admin.AdminDTO;
import com.jspider.logbackDemo.service.search.SearchService;

@RequestMapping("/")
@Controller
public class SearchController
{
	@Autowired
	private SearchService searchService;
	
	Logger log=LoggerFactory.getLogger(SearchController.class);
	
	public SearchController()
	{
		log.info("Created \t"+this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="/search.toll" , method = RequestMethod.POST)
	public ModelAndView userSearchController(HttpServletRequest req)
	{
		log.info("SearchController method started");
		
		List<AdminDTO> listFromDB = null;
		try
		{
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String tollName = req.getParameter("tollname");
		
		listFromDB = searchService.userSearchService(username, email, tollName);
		}
		catch(Exception e)
		{
			log.error("Exception occurred in SearchController layer");
			e.printStackTrace();
		}
		
		log.info("SearchController method ended");
		
		return new ModelAndView("SearchResults.jsp","list",listFromDB);
	}

}
