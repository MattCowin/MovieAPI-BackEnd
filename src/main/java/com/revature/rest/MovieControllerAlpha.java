package com.revature.rest;

import static com.revature.util.ClientMessageUtil.MOVIE_FAV_SUCCESS;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ajax.ClientMessage;
import com.revature.model.Movie;
import com.revature.service.MovieService;

@RestController("movieController")
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
	public ClientMessage addFavoriteMovie(@RequestBody Movie movie) {
		logger.trace("*** Registering a new favorite movie " + movie);
		return (movieService.registerMovie(movie)) ? MOVIE_FAV_SUCCESS : SOMETHING_WENT_WRONG;
	}

	@Override
	@GetMapping("/findAllMovies") 
	public List<Movie> findAllMovies() {
		logger.trace(" *** Getting List of all Favorite Movies. ");
		return movieService.getAllMovies();
	}

	@Override
	@PostMapping("/findMovie")
	public Movie findMovie(@RequestBody Movie movie) {
		logger.trace("*** Finding movie " + movie);
		return movieService.getMovie(movie.getTitle());
	}
/*
	@Override
	@GetMapping(value="/findMovie/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie findMovieById(@PathVariable("movieId") Integer movieId) {
		logger.trace("*** Finding movie by ID " + movieId);
		return movieService.getMovieById(movieId);
	}
*/
	@Override // GET  /findMovie?movieId=
	@GetMapping(value="/findMovie", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie findMovieById(@RequestParam("movieId") Integer movieId) {
		logger.trace("*** Finding movie by ID " + movieId);
		return movieService.getMovieById(movieId);
	}
	
	

}
