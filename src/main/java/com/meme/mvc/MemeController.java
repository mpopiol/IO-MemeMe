package com.meme.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.lang.reflect.Array;
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
import com.meme.dao.IRepository;
import com.meme.enums.Result;
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
	
	private IRepository<Meme> memeSet;
	
	public MemeController(IRepository<Meme> _repo){
		this.memeSet = _repo;
	}
	
	private MemeController() throws ClassNotFoundException, SQLException {
		IDAOManager dao = DAOManager.getInstance();
		this.memeSet = (IRepository<Meme>) dao.getDAO(Table.MEME);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model){
				
		List<Meme> memes = memeSet.toList();
        model.addAttribute("memeList", memes);
		
		return "home";
	}
	
	/**
	 * @param model - used to add element to view
	 * @return returns view name to redirect to
	 * @throws SQLException - if connection to database could not be established the exception is threw
	 * @throws ClassNotFoundException - exception which can be thrown if SQL class is not found
	 */
	
	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String details(@PathVariable int id, Model model){
		
		Meme meme = new Meme();
		meme = memeSet.firstOfDefault("id > 0");
		if(meme == null){
			return "error";
		}
		
        model.addAttribute("meme", meme);
				
		return "details";
	}
	
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public String random(Model model){
		
		List<Meme> memes = new ArrayList<Meme>();
		Meme randomMeme = new Meme();
		memes = memeSet.toList();
		
		int count = memes.size();
		Random generator = new Random(); 
		int i = generator.nextInt(count);
		randomMeme = memes.get(i);
		
        model.addAttribute("meme", randomMeme);
				
		return "details";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
		
        return new ModelAndView("add", "meme", new Meme());
    }
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("meme")Meme meme, BindingResult result, ModelMap model) {
    	
        if (result.hasErrors()) {
            return "error";
        }
        
		Result res = this.memeSet.add(meme);	
		if(res == Result.SUCCESS){		
			return "redirect:/";
		}
		else {
			return "error";
		}
    }
	
	
}