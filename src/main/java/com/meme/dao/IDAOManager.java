package com.meme.dao;

import java.sql.SQLException;

import com.meme.enums.Table;

public interface IDAOManager {

	Object getDAO(Table t) throws SQLException, ClassNotFoundException;

	void open() throws SQLException, ClassNotFoundException;

	void close() throws SQLException;

}