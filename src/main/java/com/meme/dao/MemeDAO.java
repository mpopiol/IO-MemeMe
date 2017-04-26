package com.meme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meme.models.Meme;

public class MemeDAO extends GenericDAO<Meme> {

	//Private
	private final static String TABLENAME = "MemeSet";
	
    public MemeDAO(Connection con) {
        super(con, TABLENAME);
    }

    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM " + this.TABLENAME;
        PreparedStatement stmt;
        try
        {
        stmt = this.con.prepareStatement(query);
        //stmt.setString(1, this.TABLENAME);
        ResultSet res = stmt.executeQuery();
        res.next();
        return res.getInt(1);
        }
        catch(SQLException e){ throw e; }
    }

	public List<Meme> toList() throws SQLException {
		List<Meme> resultList = new ArrayList<Meme>();
		String query = "SELECT * FROM " + this.TABLENAME;
        PreparedStatement stmt;
        try
        {
	        stmt = this.con.prepareStatement(query);
	        //stmt.setString(1, this.TABLENAME);
	        ResultSet res = stmt.executeQuery();
	        while(res.next()) 
	        {
	        	Meme meme = new Meme(
	        		res.getInt(1), 
	        		res.getString(2), 
	        		res.getString(3),
	        		res.getString(4),
	        		res.getDate(5),
	        		res.getDate(6)
	    		);	        	      	
	        	resultList.add(meme);
	    	}
	        return resultList;
        }
        catch(SQLException e){ throw e; }
	}

}
