package com.meme.dao;

import java.sql.SQLException;
import java.util.List;

import com.meme.enums.Result;
import com.meme.models.Meme;

public interface IRepository<T> {

	int count();

	List<T> toList();

	T firstOfDefault(String where);

	Result add(T item);

}