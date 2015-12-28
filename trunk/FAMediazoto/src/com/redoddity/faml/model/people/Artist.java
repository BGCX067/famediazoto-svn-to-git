package com.redoddity.faml.model.people;

import java.util.Date;

import com.redoddity.faml.model.Image;

public class Artist extends Person {
	
	private String stageName;

	// CONSTRUCTORS
	public Artist() {}
	public Artist(Long id,Image picture, String name,
			String lastname, String stageName, Date birthdate){
		setId(id);
		setImage(picture);
		setName(name);
		setLastname(lastname);
		setBirthDate(birthdate);
		this.stageName=stageName;
	}
	//GETTERS
	public String getStageName() {
		return stageName;
	}
	//SETTERS
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	
	@Override
	public String toString() {
		StringBuffer retBuffer = new StringBuffer(super.toString()+"\n");
		retBuffer.append("Stage name: "+getStageName());		
		return retBuffer.toString();
	}
}
