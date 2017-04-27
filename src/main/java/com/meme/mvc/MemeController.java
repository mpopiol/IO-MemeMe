package com.meme.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meme.dao.DAOManager;
import com.meme.dao.IDAOManager;
import com.meme.dao.MemeDAO;
import com.meme.enums.Table;
import com.meme.models.Meme;

/**
 * Handles requests for the application home page.
 */


/**
 * @author Mariusz
 * Meme controller - CRUD controller
 */
@Controller
public class MemeController{
	
	/**
	 * logger used just for debugging purposes
	 */
	private static final Logger logger = LoggerFactory.getLogger(MemeController.class);
	
	private IDAOManager dao;
	
	public MemeController(IDAOManager _dao){
		this.dao = _dao;
	}
	
	private MemeController() {
		this.dao = DAOManager.getInstance();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Locale locale, Model model) throws SQLException, ClassNotFoundException {

		MemeDAO memeSet = (MemeDAO) dao.getDAO(Table.MEME);
		
        model.addAttribute("memeList", memeSet.toList());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * @param model - used to add element to view
	 * @return returns view name to redirect to
	 * @throws SQLException - if connection to database could not be established the exception is threw
	 * @throws ClassNotFoundException - exception which can be thrown if SQL class is not found
	 */
	
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String details(@PathVariable int id, Model model) throws SQLException, ClassNotFoundException {

		MemeDAO memeSet = (MemeDAO) dao.getDAO(Table.MEME);
		Meme meme = new Meme();
		
		try{
			meme = memeSet.firstOfDefault("id > 0");
		}
		catch(SQLException e){
			model.addAttribute("errorMessage", e.getMessage());
		}
        model.addAttribute("meme", meme);
				
		return "details";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("add", "meme", new Meme());
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("meme")Meme meme, 
      BindingResult result, ModelMap model) throws ClassNotFoundException, SQLException {
        if (result.hasErrors()) {
            return "error";
        }
        MemeDAO memeSet = (MemeDAO) dao.getDAO(Table.MEME);
		memeSet.add(meme);
		
		return "redirect:/";
    }
	
	
}