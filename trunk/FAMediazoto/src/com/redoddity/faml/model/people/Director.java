package com.redoddity.faml.model.people;

import java.util.ArrayList;
import java.util.Date;

import com.redoddity.faml.model.Image;
import com.redoddity.faml.model.Movie;

public class Director extends Artist{
	private ArrayList<Movie> movies=new ArrayList<Movie>();
	
	public Director(){}
	public Director(Long id,Image image,String name,String lastName,Date birthdate){
		setId(id);
		setImage(image);
		setName(name);
		setLastname(lastName);
		setBirthDate(birthdate);
	}
	
	//Getters
	public Long getDirectorId(){
		return getId();
	}
	
	public Image getDirectorImage(){
		return getImage();
	}
	
	public String getDirectorName(){
		return getName();
	}
	
	public String getDirectorLastName(){
		return getLastname();
	}
	public ArrayList<Movie> getMovies(){
		return movies;
	}
	
	//Setters
	public void setDirectorId(Long id){
		setId(id);
	}
	
	public void setDirectorImage(Image image){
		setImage(image);
	}
	
	public void setDirectorName(String name){
		setName(name);
	}
	
	public void setDirectorLastName(String lastName){
		setLastname(lastName);
	}
	
	public void setMovies(ArrayList<Movie> movies){
		this.movies=movies;
	}
	
	//Utility methods
	public boolean addMovie(Movie m){
		return movies.add(m);
	}
	
	public boolean deleteMovie(Movie m){
		return movies.remove(m);
	}
}
