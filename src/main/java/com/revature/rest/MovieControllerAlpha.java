package com.revature.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.ajax.ClientMessage;
import com.revature.model.Movie;
import com.revature.service.MovieService;

public class MovieControllerAlpha implements MovieController {

	private static Logger logger = Logger.getLogger(MovieControllerAlpha.class);
	
	@Autowired
	private MovieService movieService;
	
	// Leave @Override in, it will alert us if a method signature changes so we catch it early.
	// Currently method stubs only, until we decide what to implement and how.
	// Annotations are also placeholder.
	// Remember to do logger traces and declare Logger logger. Asterisks are for visibility in log.
	
	@Override
	@PostMapping("/favorite")
	public ClientMessage addFavoriteMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/findAllMovies") 
	public List<Movie> findAllMovies() {
		logger.trace(" *** Getting List of all Favorite Movies. *** ");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/findMovie")
	public Movie findMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

}
