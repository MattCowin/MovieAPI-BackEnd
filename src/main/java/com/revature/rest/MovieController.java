package com.revature.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.ajax.ClientMessage;
import com.revature.model.Movie;

public interface MovieController {
													// potential functionality
	ClientMessage addFavoriteMovie(Movie movie);    // add/register a favorite movie
	List<Movie> findAllMovies();					// return all favorites
	Movie findMovie(Movie movie);					// find specific favorite's info
	Movie findMovieById(Integer movieId);
	ResponseEntity<?> getRecommended(Integer movieId);
}
