package com.revature.repository;

import java.util.List;

import com.revature.model.Movie;

// com.revature.repository = data access layer
public interface MovieRepository {
									// Potential functionalities:
	void save(Movie movie);			// Save a favorite movie to the DB
	List<Movie> findAll();			// Select * favorite movies
	Movie findByName(String name);	// Find movie by name
}
