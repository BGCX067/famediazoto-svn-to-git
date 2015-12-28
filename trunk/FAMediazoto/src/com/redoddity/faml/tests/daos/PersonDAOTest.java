package com.redoddity.faml.tests.daos;

import com.redoddity.faml.model.Image;
import com.redoddity.faml.model.daos.PersonDAO;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.Director;
import com.redoddity.faml.model.people.Person;
import com.redoddity.faml.model.people.Photographer;

import junit.framework.TestCase;


public class PersonDAOTest extends TestCase{
	PersonDAO p = new PersonDAO();
	protected void setUp() throws Exception {
		super.setUp();
		Photographer p1=new Photographer(1L,new Image(), "Pippo", "Pippi", null, 16);
		Photographer p2=new Photographer(2L,new Image(), "Foobar", "Baz", null, 1);
		Photographer p3=new Photographer(3L,new Image(), "Foo", "Bar", null, 42566);
		Artist a1 =new Artist(4L,new Image(),"Stian","Thorensen","Shagrath",null);
		Artist a2 =new Artist(5L,new Image(),"Jgor","Ognibeni","Teufel",null);
		Director d1 = new Director(6L,new Image(),"George","Lucas",null);
		Director d2 = new Director(7L,new Image(),"Tuo","Nonno",null);
		Artist a3 = new Artist(8L,new Image(),"Amethista","Aeretica","Zsd",null);
		p.addPerson(p1);
		p.addPerson(p2);
		p.addPerson(p3);
		p.addPerson(a1);
		p.addPerson(a2);
		p.addPerson(d1);
		p.addPerson(d2);
		p.addPerson(a3);
	}
	
	public void testAddPerson(){
		Photographer p1=new Photographer(8L,new Image(), "Barfoo", "Zab", null, 42);
		assertEquals(p.addPerson(p1),true);
	}
	
	public void testSearchPerson(){
	    Person p2=new Photographer(2L,new Image(), "Foobar", "Baz", null, 1);
	    assertEquals(p.searchPerson("Foobar","Baz"),p2);
	    assertEquals(p.searchPerson("Foobaz","Baz"),null);
	}
	
	public void testSortPeople() throws Exception{
		p.sortAlphabetically();
		assertEquals((Long)p.getPeople().get(0).getId(),(Long)8L);
	}
	
	public void testDeletePerson(){
		p.deletePerson(p.searchPerson("Foobar","Baz").getId());
		assertEquals(p.searchPerson("Foobar","Baz"),null);
	}
	
	public void testUpdatePerson() throws Exception{
		Person p1= new Photographer(2L,new Image(), "Foobie", "Noob", null, 54);
		assertEquals(p.updatePerson(p1),true);         // test if the multimedia file was updated succeffully
		assertEquals(p.searchPerson("Foobie","Noob"),p1);
	}
	
	public void testDeleteAllPeople() throws Exception{
		assertEquals(p.deleteAllPeople(),true);
		assertEquals(p.searchPerson("Pippo","Pippi"),null);
		assertEquals(p.searchPerson("Foobar","Baz"),null);
		assertEquals(p.searchPerson("Foo","Bar"),null);
		assertEquals(p.searchPerson("Stian","Thorensen"),null);
		assertEquals(p.searchPerson("Jgor","Ognibeni"),null);
		assertEquals(p.searchPerson("George","Lucas"),null);
		assertEquals(p.searchPerson("Tuo","Nonno"),null);
	}
}