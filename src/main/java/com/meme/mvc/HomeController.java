package com.meme.mvc;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meme.models.MemeModel;

/**
 * Handles requests for the application home page.
 */


/**
 * @author piotr
 * Main controller - home site
 */
@PropertySource("classpath:db-conf.properties")

@Controller
public class HomeController {
	
	/**
	 * logger used just for debugging purposes
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * env variable used to get property - sql connection string
	 */
	@Autowired
	private Environment env;
	
	/**
	 * @param locale - used to show date in users format
	 * @param model - used to add element to view
	 * @return returns view name to redirect to
	 * @throws SQLException - if connection to database could not be established the exception is threw
	 * @throws ClassNotFoundException - exception which can be thrown if SQL class is not found
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws SQLException, ClassNotFoundException {
		logger.info("Welcome home! The client locale is {}.", locale);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = null;
        try {
    		String url = env.getProperty("ds.connectString");
	        connection = DriverManager.getConnection(url);
	        String schema = connection.getSchema();
	        System.out.println("Successful connection - Schema: " + schema);
	        
	        String sqlQuery = "select * from memeset";
	        
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(sqlQuery);
	        
	        ArrayList<MemeModel> memes = new ArrayList<MemeModel>();
	        
	        while (resultSet.next())
            {              
                MemeModel meme = new MemeModel(
            		resultSet.getInt(1), 
            		resultSet.getString(2), 
            		resultSet.getString(3),
            		resultSet.getString(4),
            		resultSet.getDate(5),
            		resultSet.getDate(6)
        		);                
                memes.add(meme);
                
            }
	        
	        model.addAttribute("memeList", memes);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	        
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}