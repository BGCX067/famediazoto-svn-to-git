package com.redoddity.faml.model.people;

import java.util.Date;

import com.redoddity.faml.model.Image;

public class Photographer extends Artist {
	private int numberOfPhotos;
	
	public Photographer(){}
	public Photographer(Long id,Image picture, String name,
			String lastName, Date birthdate, int numberOfPhotos){
		setId(id);
		setImage(picture);
		setName(name);
		setLastname(lastName);
		setBirthDate(birthdate);
		this.numberOfPhotos=numberOfPhotos;
	}
	public void setNumberOfPhotos(int numberOfPhotos) {
		this.numberOfPhotos = numberOfPhotos;
	}

	public int getNumberOfPhotos() {
		return numberOfPhotos;
	}

	public void incrementNumberOfPhotosBy(int number) {
		this.numberOfPhotos += number;
	}
	
	public String toString(){
		return  "Name: "+getName()
			 + " Surname: "+getLastname()
			 + " Birthdate: "+getBirthDate()
			 + " Number of Photos: "+numberOfPhotos;
	}

}
