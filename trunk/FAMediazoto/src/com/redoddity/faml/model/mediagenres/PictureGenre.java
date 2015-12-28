package com.redoddity.faml.model.mediagenres;

import java.util.ArrayList;


public class PictureGenre extends Genre{

	public PictureGenre(String genre) {
		super();
		this.genre = genre;
	}

	static private ArrayList<String> pictureGenre=new ArrayList<String>();
	
	private String genre;
	
	public PictureGenre() {
		addPictureGenre("nature");
		addPictureGenre("person");
		addPictureGenre("portrait");
		addPictureGenre("porn");
		addPictureGenre("unknown");
	}
	
	static public ArrayList<String> getPictureGenres(){
		return pictureGenre;
	}
	
	public static void addPictureGenre(String genre){
		if (!pictureGenre.contains(genre)){
			pictureGenre.add(genre);
		}
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}
	


	}