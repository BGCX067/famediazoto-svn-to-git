package com.redoddity.faml.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import com.redoddity.faml.model.*;
import com.redoddity.faml.model.people.Artist;
import com.redoddity.faml.model.people.Director;
import com.redoddity.faml.model.people.Person;

import junit.framework.TestCase;

public class TestMedia extends TestCase {

	public void testMovieAttributes() throws Exception {
		ArrayList<Person> cast = new ArrayList<Person>();
		ArrayList<URL> relatedArticles = new ArrayList<URL>();
		ArrayList<String> comments = new ArrayList<String>();		
		Movie flavioMovie = new Movie();
		Movie manuelMovie = new Movie();			
		Director flavio = createDirector("Flavio");		
		Director manuel = createDirector("Manuel");
		createCast(cast);
		createRelatedArticles(relatedArticles);
		createComments(comments);
		
		flavioMovie.setTitle("Flavio movie");
		flavioMovie.setDirector(flavio);                              	
		flavioMovie.setCast(cast);                                 		                       		
		flavioMovie.setLength(5); 
		flavioMovie.setReleaseDate(new Date());                 
		flavioMovie.setPlot("Horrible");
		flavioMovie.setCoverImg(new Image());
		flavioMovie.setComments(comments);
		flavioMovie.setRelatedArticles(relatedArticles);
				
		manuelMovie.setTitle("Manuel movie");
		manuelMovie.setDirector(manuel);                              	
		manuelMovie.setCast(cast);                                 		                       		
		manuelMovie.setLength(5); 
		manuelMovie.setReleaseDate(new Date());                 
		manuelMovie.setPlot("Horrible");
		manuelMovie.setCoverImg(new Image());
		manuelMovie.setComments(comments);
		manuelMovie.setRelatedArticles(relatedArticles);

		System.out.println(flavioMovie.toString());
		System.out.println(manuelMovie.toString());
	}

	private void createComments(ArrayList<String> comments) {
		comments.add("Commento 1");
		comments.add("Commento 2");
	}

	private void createRelatedArticles(ArrayList<URL> relatedArticles)
			throws MalformedURLException {
		relatedArticles.add(new URL("http://www.google.it"));
		relatedArticles.add(new URL("http://www.google.it/ig"));
	}

	private Director createDirector(String name) {
		Director ret= new Director();
		ret.setName(name);
		return ret;
	}

	private void createCast(ArrayList<Person> cast) {
		Artist alberto = new Artist();
		alberto.setId(null);
		alberto.setName("Alberto");
		alberto.setLastname("Cristofolini");		
		Artist budspencer = new Artist();
		budspencer.setId(2L);
		budspencer.setName("Bud");
		budspencer.setLastname("Spencer");
		Artist terencehill = new Artist();
		terencehill.setId(3L);
		terencehill.setName("Terence");
		terencehill.setLastname("Hill");		
		cast.add(alberto);
		cast.add(budspencer);
		cast.add(terencehill);
	}
}
