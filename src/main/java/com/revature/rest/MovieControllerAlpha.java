package com.revature.rest;

import static com.revature.util.ClientMessageUtil.MOVIE_FAV_SUCCESS;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;
import static com.revature.util.MovieAPIUtil.API_KEY;
import static com.revature.util.MovieAPIUtil.MOVIEDB_MOVIE_URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ajax.ClientMessage;
import com.revature.model.APIResponse;
import com.revature.model.Movie;
import com.revature.model.Users;
import com.revature.service.MovieService;
import com.revature.service.UserService;

@RestController("movieController")
@CrossOrigin(origins = "*") //allow all cross-origin requests
public class MovieControllerAlpha implements MovieController {

	private static Logger logger = Logger.getLogger(MovieControllerAlpha.class);
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	
	/* 
	 * Gets the favorites of the user whose ID is supplied.
	 * Accesses a List<Movie> of that user which is created through @ManyToMany 
	 * and an @JoinTable in the Users.class
	 */
	@Override //GET   /myFavorites?userId=
	@GetMapping(value="/myFavorites", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> findMyFavorites(@RequestParam("userId") Integer userId)
	{
		Users user = userService.getUserById(userId);
		if (user != null) {
			return user.getFavoriteMovies();
		}
		logger.trace(" *** User not found in method findMyFavorites of MovieControllerAlpha. User ID = " + userId);
		return null;

	}
	
	/*
	 * Gets recommendations based on the supplied movie ID.
	 * The JSON returned contains a nested array "results", which must be extracted and passed
	 * to Jackson to be marshaled. I did this by assigning the API's JSON response to a temp
	 * object, and then calling the getResults() method to return the nested array.
	 */
	@Override  		  //Recommend?movieId=
	@GetMapping(value="/Recommend", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getRecommended(@RequestParam("movieId") Integer movieId) {
		String url = MOVIEDB_MOVIE_URL + movieId + "/recommendations?api_key="
				+ API_KEY + "&language=en-US&page=1";
		logger.trace(" *** API Request URL Built: " + url);
		RestTemplate restTemplate = new RestTemplate();	
		APIResponse myResponse = new APIResponse();	
		myResponse = restTemplate.getForObject(url, APIResponse.class);	
		return myResponse.getResults();	
	}
	
	/*
	 * By going to the popular endpoint, you will get a list of popular movies
	 * as determined by the Movie API.
	 */
	@Override  		  //Popular
	@GetMapping(value="/Popular", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getPopular() {
		String url = MOVIEDB_MOVIE_URL + "popular?api_key="
				+ API_KEY + "&language=en-US&page=1";						
		logger.trace(" *** API Request URL Built: " + url);
		RestTemplate restTemplate = new RestTemplate();						
		APIResponse myResponse = new APIResponse();							
		myResponse = restTemplate.getForObject(url, APIResponse.class);		
		return myResponse.getResults();										
	}		
	
	/*
	 * Method Depreciated. Left in for testing.
	 * Pulls a cached movie out of our Database by ID.
	 */
	@Override // GET  /findMovie?movieId=
	@GetMapping(value="/findMovie", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie findMovieById(@RequestParam("movieId") Integer movieId) {
		logger.trace("*** Finding movie by ID " + movieId);
		return movieService.getMovieById(movieId);
	}
	
	/*
	 * Method Depreciated. Left in for testing.
	 * Adds a movie to the database.
	 */
	@Override
	@PostMapping("/favorite")
	public ClientMessage addFavoriteMovie(@RequestBody Movie movie) {
		logger.trace("*** Registering a new favorite movie " + movie);
		return (movieService.registerMovie(movie)) ? MOVIE_FAV_SUCCESS : SOMETHING_WENT_WRONG;
	}

	/*
	 * Method Depreciated. Left in for testing.
	 * Returns all movies from our database.
	 */
	@Override	
	@GetMapping("/findAllMovies") 
	public List<Movie> findAllMovies() {
		logger.trace(" *** Getting List of all Favorite Movies. ");
		return movieService.getAllMovies();
	}

	/*
	 * Method Depreciated. Left in for testing.
	 * Send a title in JSON, get matching movie from Database.
	 */
	@Override
	@PostMapping("/findMovie")
	public Movie findMovie(@RequestBody Movie movie) {
		logger.trace("*** Finding movie " + movie);
		return movieService.getMovie(movie.getTitle());
	}
}