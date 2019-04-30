package com.revature.service;

import java.util.List;

import com.revature.model.Movie;

//com.revature.service = server layer (java business logic)
public interface MovieService {
										//Potential Functionalities
	public List<Movie> getAllMovies();	// get all movies from DB
	Movie getMovie(String name);		// get a movie by name from DB
	boolean registerMovie(Movie movie);	//true if movie successfully favorited / added
}
