package com.meme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.meme.enums.Table;

public class DAOManager{

	private Connection con = null;
	public static String url;
	
	public static DAOManager getInstance() {
        return DAOManagerSingleton.INSTANCE.get();
    }
	
	public Object getDAO(Table t) throws SQLException, ClassNotFoundException 
	{

	    try
	    {
	        if(this.con == null || this.con.isClosed()) //Let's ensure our connection is open   
	            this.open();
	    }
	    catch(SQLException e){ throw e; }

	    switch(t)
	    {
	    case MEME:
	        return new MemeDAO(this.con);
	    default:
	        throw new SQLException("Trying to link to an unexistant table.");
	    }

	}

    public void open() throws SQLException, ClassNotFoundException {
        try
        {
            if(this.con==null || this.con.isClosed())
    	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                this.con = DriverManager.getConnection(url);
        }
        catch(SQLException e) { throw e; }
    }

    public void close() throws SQLException {
        try
        {
            if(this.con!=null && !this.con.isClosed())
                this.con.close();
        }
        catch(SQLException e) { throw e; }
    }
    
    @Override
    protected void finalize() throws Throwable
    {

        try{ this.close(); }
        finally{ super.finalize(); }

    }
    
    private DAOManager() throws Exception {    
    	if(url == null){
	        Resource resource = new ClassPathResource("/db-conf.properties");
	        Properties props = PropertiesLoaderUtils.loadProperties(resource);
	        url = props.getProperty("ds.connectString");
    	}
    }
    
    private static class DAOManagerSingleton {

        public static final ThreadLocal<DAOManager> INSTANCE;
        static
        {
            ThreadLocal<DAOManager> dm;
            try
            {
                dm = new ThreadLocal<DAOManager>(){
                    @Override
                    protected DAOManager initialValue() {
                        try
                        {
                            return new DAOManager();
                        }
                        catch(Exception e)
                        {
                            return null;
                        }
                    }
                };
            }
            catch(Exception e){
                dm = null;
            }
            INSTANCE = dm;
        }        

    }

}
