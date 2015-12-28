package com.redoddity.faml.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

import com.redoddity.faml.Utils;

public class MultimediaFile {
	public MultimediaFile() {
	}

	public MultimediaFile(Long id,String title, URI uri, int previewTime) {
		setId(id);
		setTitle(title);
		setUri(uri);
		setPreviewTime(previewTime);
	}

	private transient InputStream fis;
	private URI uri;
	private Long id;
	private String title; // title of the media
	private int previewTime; // seconds the user may preview the media

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public URI getUri() {
		return uri;
	}

	public void setPreviewTime(int previewTime) {
		this.previewTime = previewTime;
	}

	public int getPreviewTime() {
		return previewTime;
	}

	public String toString() {
		return "Media Title: " + getTitle() + " File Path: " + getUri().toString()
				+ " Preview Time: " + getPreviewTime();
	}

	public boolean equals(Object obj) {
		return Utils.equals(this, obj);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	// USEFUL METHODS
	public InputStream getMultimediaFile(boolean buffered) throws FileNotFoundException {
		File multimediaFile = getFileIfReadable();
		if(buffered){
			fis = new BufferedInputStream(new FileInputStream(multimediaFile));
		}else{
			fis= new FileInputStream(multimediaFile);
		}
		return fis;

	}
	private File getFileIfReadable() {
		File ret = new File(getUri());
		if (!ret.exists() || !ret.canRead()) {
			return null;
		}
		return ret;
	}
}