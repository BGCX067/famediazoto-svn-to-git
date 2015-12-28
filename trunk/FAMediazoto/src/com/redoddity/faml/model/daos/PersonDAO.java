package com.redoddity.faml.model.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.redoddity.faml.model.Image;
import com.redoddity.faml.model.Media;
import com.redoddity.faml.model.Track;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.Person;

public class PersonDAO{
	private List<Person> people=new ArrayList<Person>();

	public PersonDAO() {}
	
	public void setTestData(List<Person> testData) {
		this.people = testData;
	}
	
	public List<Person> getPeople(){
		return people;
	}

	public boolean addPerson(Person p) {
		return people.add(p);
	}

	public Person searchPerson(String name, String surname) {
		for (Person p : people) {
			if (p.getName().equals(name) && (p.getLastname().equals(surname))) {
				return p;
			}
		}
		return null;
	}
	
	public Person findPerson(Long id) {

		for (Person person : people) {
			if (person.getId().equals(id))
				return person;
		}

		return null;
	}
	
	public boolean deletePerson(Long id) {
		for (Person p : people) {
			if (p.getId().equals(id)) {
				people.remove(people.indexOf(p));
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteAllPeople() {
		return people.removeAll(people);
	}
	
	public boolean updatePerson(Person updated) {
		for (Person p : people) {
			if (p.getId().equals(updated.getId())) {
				people.set(people.indexOf(p), updated);
				return true;
			}
		}
		return false;
	}
	
	public void sortAlphabetically(){
		Collections.sort(people);
	}
	
	public List<Person> get() {
		return people;
	}
	
	public Person getPerson(Long id) {
		return findPerson(id);
	}
	
	
	public Person update(Long id, String name, String lastname, String stageName, Date birthDate, Image image){
		for (Person person : people) {
			if (person.getId().equals(id)){
				person.setName(name);
				person.setLastname(lastname);
				
				person.setBirthDate(birthDate);
				person.setImage(image);
				if (person instanceof Artist){
					((Artist) person).setStageName(stageName);
				} 
			return person;
			}
		}
		return null;
	}
}
