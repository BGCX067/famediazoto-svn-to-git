package com.redoddity.faml.model.mediagenres;

import java.util.ArrayList;


public class MovieGenre{

	public MovieGenre(String genre) {
		super();
		this.genre = genre;
	}

	static private ArrayList<String> movieGenre=new ArrayList<String>();
	
	private String genre;
	
	public MovieGenre() {
		addMovieGenre("nature");
		addMovieGenre("person");
		addMovieGenre("portrait");
		addMovieGenre("porn");
		addMovieGenre("unknown");
	}
	
	static public ArrayList<String> getMovieGenres(){
		return movieGenre;
	}
	
	public static void addMovieGenre(String genre){
		if (!movieGenre.contains(genre)){
			movieGenre.add(genre);
		}
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}
	


	}