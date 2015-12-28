package com.redoddity.faml.model.mediagenres;

import java.util.ArrayList;


public class AlbumGenre{

	public AlbumGenre(String genre) {
		super();
		this.genre = genre;
	}

	static private ArrayList<String> albumGenre=new ArrayList<String>();
	
	private String genre;
	
	public AlbumGenre() {
		addAlbumGenre("metal");
		addAlbumGenre("pop");
		addAlbumGenre("dance");
		addAlbumGenre("rock");
		addAlbumGenre("unknown");
	}
	
	static public ArrayList<String> getAlbumGenres(){
		return albumGenre;
	}
	
	public static void addAlbumGenre(String genre){
		if (!albumGenre.contains(genre)){
			albumGenre.add(genre);
		}
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}
	


	}
