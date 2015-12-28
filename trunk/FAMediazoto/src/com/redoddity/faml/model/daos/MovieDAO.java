package com.redoddity.faml.model.daos;

import java.util.Hashtable;
import com.redoddity.faml.model.Movie;

public class MovieDAO{
	Hashtable<Long, Movie> movies = new Hashtable<Long, Movie>();
	public Movie addMovie(Movie movie) {
		movies.put(movie.getId(), movie);
		return movie;
	}

	public Movie removeMovie(Long id) {
		Movie removed=movies.get(id);
		if(removed!=null){
			movies.remove(id);			
		}
		return removed;
	}

	public Integer removeAllMovies() {
		Integer removed = movies.size(); 
		movies.clear();
		if(movies.size()==0)
			return removed;
		return null;
	}

	public Movie getMovie(Long id) {
		return movies.get(id);
	}

	public Movie updateMovie(Movie m) {
		Movie toUpdate=getMovie(m.getId());
		if(toUpdate!=null){
			movies.put(m.getId(), m);
		}
		return movies.get(m.getId());
	}

}
