package com.redoddity.faml.model.mediagenres;

import java.util.ArrayList;


public class TrackGenre extends Genre{

	public TrackGenre(String genre) {
		super();
		this.genre = genre;
	}

	static private ArrayList<String> trackGenre=new ArrayList<String>();
	
	private String genre;
	
	public TrackGenre() {/*
		addTrackGenre("metal");
		addTrackGenre("pop");
		addTrackGenre("dance");
		addTrackGenre("rock");
		addTrackGenre("unknown");
		*/
	}
	
	static public ArrayList<String> getTrackGenres(){
		return trackGenre;
	}
	
	public static void addTrackGenre(String genre){
		if (!trackGenre.contains(genre)){
			trackGenre.add(genre);
		}
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}
	


	}
