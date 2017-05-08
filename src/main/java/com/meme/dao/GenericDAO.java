package com.meme.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDAO<T> {
    //Protected
    protected final String tableName;
    protected Connection con;
    
    protected GenericDAO(Connection con, String tableName) {
        this.tableName = tableName;
        this.con = con;
    }

}
