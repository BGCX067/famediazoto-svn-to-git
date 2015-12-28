package com.redoddity.faml.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.people.Director;
import com.redoddity.faml.model.people.Person;

public class Movie extends Media {
	Director director;
	ArrayList<Person> cast = new ArrayList<Person>();
	Integer minutesLength;// in minutes
	Date releaseDate;
	String plot;
	Image coverImg;

	// [preview - multimedia]

	public Movie() {
	}

	public Movie(Long id, String title, Integer rating, Director director,
			ArrayList<Person> cast, Integer minutesLength, Date releaseDate,
			String plot, Image coverImg, ArrayList<URL> relatedArticles,
			ArrayList<String> comments, Genre genre) {
		super();
		setTitle(title);
		setId(id);
		setRating(rating);
		setRelatedArticles(relatedArticles);
		setComments(comments);
		setGenre(genre);
		this.director = director;
		this.cast = cast;
		this.minutesLength = minutesLength;
		this.releaseDate = releaseDate;
		this.plot = plot;
		this.coverImg = coverImg;
	}

	// GETTERS
	public Director getDirector() {
		return director;
	}

	public ArrayList<Person> getCast() {
		return cast;
	}

	public Integer getLength() {
		return minutesLength;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getPlot() {
		return plot;
	}

	public Image getCoverImg() {
		return coverImg;
	}

	// SETTERS
	public void setLength(Integer minutes) {
		this.minutesLength = minutes;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public void setCast(ArrayList<Person> cast) {
		this.cast = cast;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public void setCoverImg(Image coverImg) {
		this.coverImg = coverImg;
	}

	@Override
	public String toString() {
		StringBuffer retBuffer = new StringBuffer(super.toString() + "\n");
		if (null!=director) retBuffer.append("Direttore: " + director.toString() + "\n");
		if (null!=cast) retBuffer.append("Cast: " + getCast() + "\n");
		if (null!=getLength()) retBuffer.append("Length: " + getLength() + "\n");
		if (null!=releaseDate) retBuffer.append("Release date: " + getReleaseDate() + "\n");
		if (null!=plot) retBuffer.append("Plot: " + getPlot());
		return retBuffer.toString();
	}
}
