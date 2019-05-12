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
	
	@Override // GET  /findMovie?movieId=
	@GetMapping(value="/findMovie", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie findMovieById(@RequestParam("movieId") Integer movieId) {
		logger.trace("*** Finding movie by ID " + movieId);
		return movieService.getMovieById(movieId);
	}
	
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
	
	@Override  		  //Recommend?movieId=
	@GetMapping(value="/Recommend", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getRecommended(@RequestParam("movieId") Integer movieId) {
		String url = MOVIEDB_MOVIE_URL + movieId + "/recommendations?api_key="
				+ API_KEY + "&language=en-US&page=1";						//build the uri string
		logger.trace(" *** API Request URL Built: " + url);
		RestTemplate restTemplate = new RestTemplate();						//new rest template
		APIResponse myResponse = new APIResponse();							//new temp object to hold response in supplied format
		myResponse = restTemplate.getForObject(url, APIResponse.class);		//get the API's info
		return myResponse.getResults();										//get just the array of Movies from the temp object.
	}																		//This solved the problem with nested JSON.
	
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
	
	@Override	// Method depreciated. Left in for testing purposes.
	@PostMapping("/favorite")
	public ClientMessage addFavoriteMovie(@RequestBody Movie movie) {
		logger.trace("*** Registering a new favorite movie " + movie);
		return (movieService.registerMovie(movie)) ? MOVIE_FAV_SUCCESS : SOMETHING_WENT_WRONG;
	}

	@Override	// Method depreciated. Left in for testing purposes.
	@GetMapping("/findAllMovies") 
	public List<Movie> findAllMovies() {
		logger.trace(" *** Getting List of all Favorite Movies. ");
		return movieService.getAllMovies();
	}

	@Override	// Method depreciated. Left in for testing purposes.
	@PostMapping("/findMovie")
	public Movie findMovie(@RequestBody Movie movie) {
		logger.trace("*** Finding movie " + movie);
		return movieService.getMovie(movie.getTitle());
	}
}