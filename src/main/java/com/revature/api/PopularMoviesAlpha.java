package com.revature.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import com.revature.model.PopMovie;

public class PopularMoviesAlpha implements PopularMovies{
	
	private static Logger logger = Logger.getLogger(PopularMoviesAlpha.class);
	
	public PopularMoviesAlpha() {
		
	}
	
	
	@RequestMapping(value = "/popularmovies", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	private PopMovie getMovies(PopMovie popMovie){
		logger.trace("Attempting to pull from the Popular Movies API");
	    final String url = "https://api.themoviedb.org/3/movie/popular?api_key=0c0310c62d5381ede7d4780860ab79f6&language=en-US&page=1";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    PopMovie result = restTemplate.getForObject(url, PopMovie.class);
	   return result;  
	   
	}
}
