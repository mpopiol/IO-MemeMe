package com.meme.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meme.dao.DAOManager;
import com.meme.dao.IDAOManager;
import com.meme.dao.IRepository;
import com.meme.enums.Table;
import com.meme.models.Meme;

/**
 * Handles requests for the application home page.
 */


/**
 * @author piotr
 * Main controller - home site
 */

@Controller
public class HomeController{
	
	/**
	 * logger used just for debugging purposes
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private IDAOManager dao = DAOManager.getInstance();
	
	/**
	 * @param locale - used to show date in users format
	 * @param model - used to add element to view
	 * @return returns view name to redirect to
	 * @throws SQLException - if connection to database could not be established the exception is threw
	 * @throws ClassNotFoundException - exception which can be thrown if SQL class is not found
	 */
	
	@RequestMapping(value = "/oldHome", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws SQLException, ClassNotFoundException {
		logger.info("Welcome home! The client locale is {}.", locale);

		IRepository memeSet = (IRepository) dao.getDAO(Table.MEME);
		
        model.addAttribute("memeList", memeSet.toList());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}