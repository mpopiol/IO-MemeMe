package com.meme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meme.enums.Result;
import com.meme.models.Meme;

public class MemeDAO extends GenericDAO<Meme> {

	//Private
	private final static String TABLENAME = "MemeSet";
	
	private static final Logger logger = LoggerFactory.getLogger(MemeDAO.class);
	
    public MemeDAO(Connection con) {
        super(con, TABLENAME);
    }

    private Meme createMemeFromResult(ResultSet res) throws SQLException{
    	Meme meme = new Meme(
    			res.getInt(1), 
        		res.getString(2), 
        		res.getString(3),
        		res.getString(4),
        		res.getString(5),
        		res.getString(6), 
        		res.getDate(7),
        		res.getDate(8)
    		);
    	return meme;
    }
    
    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) FROM " + MemeDAO.TABLENAME;
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
		String query = "SELECT * FROM " + MemeDAO.TABLENAME;
        PreparedStatement stmt;
        try
        {
	        stmt = this.con.prepareStatement(query);
	        //stmt.setString(1, this.TABLENAME);
	        ResultSet res = stmt.executeQuery();
	        while(res.next()) 
	        {
	        	Meme meme = this.createMemeFromResult(res);       	      	
	        	resultList.add(meme);
	    	}
	        stmt.close();
	        return resultList;
        }
        catch(SQLException e){ throw e; }
	}
	
	public Meme firstOfDefault(String where) throws SQLException{
		String query = "SELECT * FROM " + MemeDAO.TABLENAME + " WHERE " + where;
        PreparedStatement stmt;
        try
        {
	        stmt = this.con.prepareStatement(query);
	        ResultSet res = stmt.executeQuery();
	        res.next();
	        Meme meme = this.createMemeFromResult(res);
	        stmt.close();
	        return meme;
        }
        catch(SQLException e){ throw e; }
	}

	public Result add(Meme meme) {
		String query = "INSERT INTO "+ MemeDAO.TABLENAME +" ([Title],[Content],[ImgLink],[Details],[Author]) VALUES(" + meme.toString() + ")";
        PreparedStatement stmt;
        int affectedRows = 0;
        try{
	        stmt = this.con.prepareStatement(query);
	        affectedRows = stmt.executeUpdate();
	        stmt.close();	        
        }
        catch(SQLException e){ 
        	logger.error(e.toString());
        	return Result.FAIL;
        }
        
    	if(affectedRows == 1){
    		return Result.SUCCESS;
    	}
    	else{
    		return Result.FAIL;
    	}
	}

}
