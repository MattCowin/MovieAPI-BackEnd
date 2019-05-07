package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public @ResponseBody ClientMessage addFavoriteMovie(Movie movie) {
		logger.trace("*** Registering a new favorite movie " + movie);
		return (movieService.registerMovie(movie)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WENT_WRONG;
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
	public @ResponseBody Movie findMovie(Movie movie) {
		logger.trace("*** Finding movie " + movie);
		return movieService.getMovie(movie.getTitle());
	}

}
