package com.redoddity.faml.model;

import java.util.List;

import com.redoddity.faml.model.mediagenres.AlbumGenre;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.ArtistGroup;
import com.redoddity.faml.model.people.Person;

public class Album {

	

	Long id;// album id
	String title;// album title
	List<Track> tracks;// track list
	Person artist;// artists
	Picture frontCover;//album cover
	AlbumGenre genre;
	
	public Album(){}

	
	public Album(Long id, String title, List<Track> tracks, Person artist,
			Picture frontCover, AlbumGenre genre) {
		super();
		this.id = id;
		this.title = title;
		this.tracks = tracks;
		this.artist = artist;
		this.frontCover = frontCover;
		this.genre = genre;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long l) {
		this.id = l;
	}

	public String getTitle() {
		return title;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public Person getArtist() {
		return artist;
	}

	public Picture getFrontCover() {
		return frontCover;
	}
	
	public void setID(long id) {
		this.id = id;

	}

	public void setTitle(String title) {
		this.title = title;

	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;

	}

	public void setArtist(Person artist) {
		this.artist = artist;

	}

	public void setFrontCover(Picture frontCover) {
		this.frontCover = frontCover;
	}

	public AlbumGenre getGenre() {
		return genre;
	}

	public void setGenre(AlbumGenre genre) {
		this.genre = genre;
	}

	public String toString(Album album){
		StringBuffer sb = new StringBuffer();
		sb.append("Album Title ").append(album.getTitle()).append(" Album Artist ");
		sb.append("Genre ").append(album.getGenre());
		return sb.toString();
	}
	/*
	public int compareTo(Object o) {
		Album other;
		if(!(o instanceof Album)){
			return -1;
		}
		other = (Album) o;
		return (int)(this.getId() - other.getId());
	}*/
}	
