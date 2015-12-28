package com.redoddity.faml.tests.daos;

import com.redoddity.faml.model.Movie;
import com.redoddity.faml.model.daos.MovieDAO;

import junit.framework.TestCase;

public class MovieDAOTest extends TestCase {	
	private MovieDAO movieDao;
		
	protected void setUp() throws Exception {
		super.setUp();
		movieDao = new MovieDAO();
	}
	

	private Movie createSampleMovie() {
		Movie movie = new Movie();
		movie.setId(1L);
		movie.setTitle("The big Lebowski");
		movie.setLength(120);//minutes
		return movie;
	}
	//CRUD tests
	public void testAddMovie() throws Exception {
		Movie movie = createSampleMovie();
		Movie m = movieDao.addMovie(movie);
		assertEquals(m.equals(movie), true);		
	}
	public void testRemoveMovie() throws Exception {	
		Movie movie = movieDao.addMovie(createSampleMovie());		
		Movie m = movieDao.removeMovie(1L);
		assertNotNull(m);
		assertEquals(m.equals(movie), true);
		Movie notFound = movieDao.removeMovie(7L);
		assertNull(notFound);
	}
	public void testGetMovie() throws Exception {
		movieDao.addMovie(createSampleMovie());		
		Movie m = movieDao.getMovie(1L);
		assertNotNull(m);
		Movie notFound = movieDao.getMovie(7L);
		assertNull(notFound);
	}
	public void testUpdateMovie() throws Exception {
		movieDao.addMovie(createSampleMovie());		
		Movie m = movieDao.getMovie(1L);
		assertNotNull(m);
		m.setPlot("My plot");
		Movie updated=movieDao.updateMovie(m);
		assertEquals(m.equals(updated), true);;		
		
	}
	public void testRemoveAllMovies() throws Exception {
		movieDao.addMovie(createSampleMovie());
		assertEquals(movieDao.removeAllMovies(),new Integer(1));
	}
}
