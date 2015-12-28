package com.redoddity.faml.model.people;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.redoddity.faml.Utils;
import com.redoddity.faml.model.Image;
import com.redoddity.faml.model.Media;

public class Person implements Comparable<Person>{
	private Long id;
	private Image image;
	private String name;
	private String lastname;
	private Date birthDate;

	public Person() {
		id = null;
		image = null;
		name = null;
		lastname = null;
		birthDate = null;
	}

	public Person(Long id, Image image, String name, String lastname,
			Date birthDate) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.lastname = lastname;
		this.birthDate = birthDate;
	}
	public Person(Long id) {
		super();
		this.id = id;		
	}

	// GETTERS
	public Long getId() {
		return id;
	}

	public Image getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	

	// SETTERS
	public void setId(Long id) {
		this.id = id;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastname(String surname) {
		this.lastname = surname;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Integer getAge(Person person)
	{
		long now = new Date().getTime();
		long birth = birthDate.getTime();
		long age=now-birth;
		SimpleDateFormat formatter = new SimpleDateFormat("yy");
		return new Integer(formatter.format(age));
	}

	@Override
	public final boolean equals(Object other) {
		return equalsInternal(other);
	}
	protected boolean equalsInternal(Object other) {
		return Utils.equals(this, other);
	}

	@Override
	public String toString() {
		StringBuffer retBuffer = new StringBuffer();
		retBuffer.append("Id: " + getId() + "\n");
		retBuffer.append("Name: " + getName() + "\n");
		retBuffer.append("Lastname: " + getLastname() + "\n");
		retBuffer.append("Birth date: " + getBirthDate());
		return retBuffer.toString();
	}

	public int compareTo(Person p) {
		if (this.getLastname().compareTo(p.lastname)<0) return -1;
		if (this.getLastname().compareTo(p.lastname)>0) return 1;
		if (this.getLastname().compareTo(p.lastname)==0 && (this.getName().compareTo(p.getLastname())<0)) return -1;
		if (this.getLastname().compareTo(p.lastname)==0 && (this.getName().compareTo(p.getLastname())>0)) return 1;
		return 0;
	}

}