package com.revature.rest;

import static com.revature.util.ClientMessageUtil.MOVIE_FAV_SUCCESS;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.model.Movie;
import com.revature.service.MovieService;

@Controller("movieController")
@CrossOrigin(origins = "*") //allow all cross-origin requests
public class MovieControllerAlpha implements MovieController {

	private static Logger logger = Logger.getLogger(MovieControllerAlpha.class);
	
	@Autowired
	private MovieService movieService;
	
	/*
	 * addFavoriteMovie - accepts a Movie object from Angular sent as JSON
	 * Calls movieService.registerMovie(Movie) which
	 * calls MovieRepositoryHibernate.save(Movie) which
	 * handles the logic to insert the row in the database.
	 */
	
	@Override
	@PostMapping("/favorite")
	public @ResponseBody ClientMessage addFavoriteMovie(@RequestBody Movie movie) {
		logger.trace("*** Registering a new favorite movie " + movie);
		return (movieService.registerMovie(movie)) ? MOVIE_FAV_SUCCESS : SOMETHING_WENT_WRONG;
	}

	@Override
	@GetMapping("/findAllMovies") 
	public @ResponseBody List<Movie> findAllMovies() {
		logger.trace(" *** Getting List of all Favorite Movies. ");
		return movieService.getAllMovies();
	}

	@Override
	@PostMapping("/findMovie")
	public @ResponseBody Movie findMovie(@RequestBody Movie movie) {
		logger.trace("*** Finding movie " + movie);
		return movieService.getMovie(movie.getTitle());
	}

}
