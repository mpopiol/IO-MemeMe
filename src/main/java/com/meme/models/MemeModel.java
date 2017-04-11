package com.meme.models;

import java.sql.Date;

public class MemeModel {
	private int id;
	private String title;
	private String content;
	private String author;
	private Date createDate;
	private Date lastEditDate;
	
	/**
	 * @param _id
	 * @param _title
	 * @param _content
	 * @param _author
	 * @param _createDate
	 * @param _lastEditDate
	 */
	public MemeModel(int _id, String _title, String _content, String _author, Date _createDate, Date _lastEditDate) {
		super();
		this.id = _id;
		this.title = _title;
		this.content = _content;
		this.author = _author;
		this.createDate = _createDate;
		this.lastEditDate = _lastEditDate;
	}
	/**
	 * @return the _id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setId(int _id) {
		this.id = _id;
	}
	/**
	 * @return the _title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param _title the _title to set
	 */
	public void setTitle(String _title) {
		this.title = _title;
	}
	/**
	 * @return the _content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param _content the _content to set
	 */
	public void setContent(String _content) {
		this.content = _content;
	}
	/**
	 * @return the _author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param _author the _author to set
	 */
	public void setAuthor(String _author) {
		this.author = _author;
	}
	/**
	 * @return the _createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param _createDate the _createDate to set
	 */
	public void setCreateDate(Date _createDate) {
		this.createDate = _createDate;
	}
	/**
	 * @return the _lastEditDate
	 */
	public Date getLastEditDate() {
		return lastEditDate;
	}
	/**
	 * @param _lastEditDate the _lastEditDate to set
	 */
	public void setLastEditDate(Date _lastEditDate) {
		this.lastEditDate = _lastEditDate;
	}
}
