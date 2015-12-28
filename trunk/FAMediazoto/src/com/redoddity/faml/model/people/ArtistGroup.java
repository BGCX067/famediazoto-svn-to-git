package com.redoddity.faml.model.people;

import java.util.List;

public class ArtistGroup extends Artist{
	
	private List<Artist> components;
	
	//CONSTRUCTORS
	public ArtistGroup(){}
	public ArtistGroup(String groupName, List<Artist> components){
		this.components = components;
		setStageName(groupName);
		setName(groupName);
	}
	//GETTERS
	public List<Artist> getComponents() {		
		return components;
	}
	// SETTERS
	public void setComponents(List<Artist> components) {
		this.components = components;
	}			
}
