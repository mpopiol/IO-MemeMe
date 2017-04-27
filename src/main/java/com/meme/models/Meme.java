package com.meme.models;

import java.sql.Date;

public class Meme {
	private int id;
	private String title;
	private String content;
	private String author;
	private Date createDate;
	private Date lastEditDate;
	private String imgLink;
	private String details;
	
	/**
	 * @param _id
	 * @param _title
	 * @param _content
	 * @param _author
	 * @param _createDate
	 * @param _lastEditDate
	 */
	public Meme(int _id, String _title, String _content, String _imgLink, String _details, String _author, Date _createDate, Date _lastEditDate) {
		super();
		this.id = _id;
		this.title = _title;
		this.content = _content;
		this.imgLink = _imgLink;
		this.details = _details;
		this.author = _author;
		this.createDate = _createDate;
		this.lastEditDate = _lastEditDate;
	}
	public Meme() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		//[Title],[Content],[ImgLink],[Details],[Author]
		return String.format("'%s', '%s', '%s', '%s', '%s'", 
				this.title, this.content, this.imgLink, this.details, this.author);
		
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
	/**
	 * @return the imgLink
	 */
	public String getImgLink() {
		return imgLink;
	}
	/**
	 * @param imgLink the imgLink to set
	 */
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
}
