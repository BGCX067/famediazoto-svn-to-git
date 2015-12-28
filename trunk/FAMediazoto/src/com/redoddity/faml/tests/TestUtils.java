package com.redoddity.faml.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

import com.redoddity.faml.Utils;

import com.redoddity.faml.model.Media;
import com.redoddity.faml.model.Movie;
import com.redoddity.faml.model.people.Director;

public class TestUtils extends TestCase{
	private Movie foo;		                 		                       					
	private Movie bar;
	private Media media=new Media();
	private Date  now=new Date();
	private Director director1;
	private Director director2;
	
	// SET-UP METHODS
	private Movie getAnewMovieWithAllFieldsToNull() {
		Movie newMovie = new Movie();
		newMovie.setDirector(null);                              	
		newMovie.setCast(null);                                 		                       		
		newMovie.setLength(null); 
		newMovie.setReleaseDate(null);                 
		newMovie.setPlot(null);
		newMovie.setCoverImg(null);
		return newMovie;
	}
	private void createSampleMedia(Media m)throws MalformedURLException{
		ArrayList<URL> relatedArticles = new ArrayList<URL>();
		ArrayList<String> comments = new ArrayList<String>();
		relatedArticles.add(new URL("http://www.google.it"));
		relatedArticles.add(new URL("http://www.google.it/ig"));
		comments.add("Commento 1");
		comments.add("Commento 2");
		m=new Media();		
		m.setId(1L);
		m.setRating(10);
		m.setTitle("The big Lebowsky");
		m.setRelatedArticles(relatedArticles);
		m.setComments(comments);
		//m.setGenre(new AlbumGenreStrategy(AlbumGenreStrategy.AlbumGenre.DANCE));
	}
	protected void setUp() throws Exception {
		super.setUp();
		foo = getAnewMovieWithAllFieldsToNull();		                 		                       					
		bar = getAnewMovieWithAllFieldsToNull();
		director1 = new Director();
		director2 = new Director();
		createSampleMedia(media);
	}
	
	public void testMovieAllNullEqualTrue() throws Exception {
		assertEquals(Utils.equals(bar, foo), true);			
	}
	
	public void testMoviePlotlEqualFalse() throws Exception {		
		foo.setPlot("Some plot");		
		assertEquals(Utils.equals(bar, foo), false);						
		bar.setPlot("Some other plot");
		assertEquals(Utils.equals(bar, foo), false);
	}	
	public void testMoviePlotEqualTrue() throws Exception {		
		foo.setPlot("Some plot");						
		bar.setPlot("Some plot");
		assertEquals(Utils.equals(bar, foo), true);			
	}
	
	public void testMovieLenghtEqualFalse() throws Exception {
		foo.setLength(10); 	 			
		assertEquals(Utils.equals(bar, foo), false);							
		bar.setLength(12);
		assertEquals(Utils.equals(bar, foo), false);						
	}	
	public void testMovieLenghtEqualTrue() throws Exception {
		foo.setLength(10); 	 	
		bar.setLength(10);    			
		assertEquals(Utils.equals(bar, foo), true);				
	}
	
	public void testMovieReleaseDateEqualTrue() throws Exception { 		
	 	foo.setReleaseDate(now);                 				   
		bar.setReleaseDate(now);                 		
		assertEquals(Utils.equals(bar, foo), true);			
	}
	public void testMovieReleaseDateEqualFalse() throws Exception {		
		foo.setReleaseDate(now);                 						
		assertEquals(Utils.equals(bar, foo), false);				
		bar.setReleaseDate(new Date(1999,10,10));
		assertEquals(Utils.equals(bar, foo), false);
	}

	public void testMovieDirectorEqual() throws Exception {
		
		director1.setName("Flavio");
		foo.setDirector(director1);
		assertEquals(bar.equals(foo), false);
		assertEquals(foo.equals(bar), false);
				
		director2.setName("Manuel");
		bar.setDirector(director2);
		assertEquals(bar.equals(foo), false);
		assertEquals(foo.equals(bar), false);						
		
		director2.setName("Flavio");
		assertEquals(bar.equals(foo), true);
		assertEquals(foo.equals(bar), true);
		assertEquals(Utils.equals(bar, foo), true);		
	}
	
	public void testMediaEquality() throws Exception {
		Media anotherMedia = new Media();
		createSampleMedia(anotherMedia);
		media.equals(anotherMedia);
		assertEquals(media.equals(anotherMedia),true);
		anotherMedia.setRating(2);
		assertEquals(media.equals(anotherMedia),false);
	}
}
