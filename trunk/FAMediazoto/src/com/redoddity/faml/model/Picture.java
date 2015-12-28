package com.redoddity.faml.model;

import java.net.URL;
import java.util.ArrayList;

import com.redoddity.faml.model.mediagenres.Genre;
import com.redoddity.faml.model.people.Photographer;

public class Picture extends Media {
	private Photographer photographer;
	private ArrayList<String> tags;
	private int height;
	private int width; // resolution, like 1024 768
	private int size; // in KB
	private int numberOfDownloads;
	private Image img;

	public Picture() {
	}

	public Picture(Long id, String title, Integer rating,
			Photographer photographer, ArrayList<String> tags, int height,
			int width, int size, Image img, int numberOfDownloads,
			ArrayList<URL> relatedArticles, ArrayList<String> comments,
			Genre genre) {
		super();
		setTitle(title);
		setId(id);
		setRating(rating);
		setRelatedArticles(relatedArticles);
		setComments(comments);
		setGenre(genre);
		this.tags = tags;
		this.photographer = photographer;
		this.height = height;
		this.width = width;
		this.numberOfDownloads = numberOfDownloads;
		this.img = img;
	}

	public Photographer getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Photographer photographer) {
		this.photographer = photographer;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumberOfDownloads() {
		return numberOfDownloads;
	}

	public void setNumberOfDownloads(int numberOfDownloads) {
		this.numberOfDownloads = numberOfDownloads;
	}

	public void incrementNumberOfDownloadsBy(int number) {
		this.numberOfDownloads += number;
	}

	public String toString() {
		if (null!=photographer)return "Title: " + getTitle() + " Photographer: "
				+ getPhotographer().getName() + " Resolution: " + getWidth()
				+ "x" + getHeight() + " Number of Downloads: "
				+ getNumberOfDownloads();
		return "Title: " + getTitle() + " Resolution: " + getWidth()
		+ "x" + getHeight() + " Number of Downloads: "
		+ getNumberOfDownloads();
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Image getImg() {
		return img;
	}
}
