package com.redoddity.faml.model;

import java.net.URL;
import java.util.ArrayList;

import com.redoddity.faml.Utils;
import com.redoddity.faml.model.mediagenres.Genre;

public class Media {
	
	private Long id; 
	private Integer rating;
	private Integer yr;
	private String title; 
	private ArrayList<URL> relatedArticles = new ArrayList<URL>(); 
	private ArrayList<String> comments = new ArrayList<String>();
	private Genre genre;
		
	//GETTERS
	public Long getId() {
		return id;
	}
	public Integer getRating() {
		return rating;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<URL> getRelatedArticles() {
		return relatedArticles;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public Genre getGenre() {
		return genre;
	}
	public Integer getYr() {
		return yr;
	}
	
	// SETTERS
	public void setId(Long id) {
		this.id = id;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setRelatedArticles(ArrayList<URL> relatedArticles) {
		this.relatedArticles = relatedArticles;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public void setYr(Integer yr) {
		this.yr = yr;
	}

	@Override
	public final boolean equals(Object other){
		return equalsInternal(other);
	}
	protected boolean equalsInternal(Object other){
	   return Utils.equals(this, other);
	}
	
	@Override
	public String toString() {
		StringBuffer retBuffer = new StringBuffer();
		retBuffer.append("Id: "+getId()+"\n");
		retBuffer.append("Title: "+getTitle()+"\n");
		retBuffer.append("Related articles: "+getRelatedArticles()+"\n");
		retBuffer.append("Comments: "+getComments()+"\n");
		retBuffer.append("Genre: "+getGenre());
		return retBuffer.toString();
	}
}
