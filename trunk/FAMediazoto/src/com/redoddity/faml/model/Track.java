package com.redoddity.faml.model;

import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.people.Person;

public class Track extends Media implements Comparable<Track> {
	
	private Integer length;
	private Person  artist;	
	private String  lyrics;

	// multimedia preview
	public Track() {}

	public Track(long id, String title, Person artist, Genre genre, int length, 

			int yr, String lyrics) {
		setId(id);
		setTitle(title);
		setGenre(genre);
		setYr(yr);
		this.length = length;				
		this.artist = artist;		
		this.lyrics = lyrics;
	}

	// Getter
	public Person getArtist() {
		return artist;
	}
	public String getLyrics() {
		return lyrics;
	}
	public Integer getLength() {
		return length;
	}
	
	// SETTERS
	public void setLength(Integer length) {
		this.length = length;
	}	
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	public void setArtist(Person artist) {
		this.artist = artist;
	}	

	// ordered by year
	public int compareTo(Track other) {			
		return getYr() - other.getYr();
	}

	public String toString() {
		return "Title: " + getTitle() + " Artist: " + artist 
				+ " Length: " + length + " Lyrics: " + lyrics;
	}

}

