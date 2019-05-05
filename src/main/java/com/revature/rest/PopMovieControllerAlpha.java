package com.revature.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.api.PopularMovies;
import com.revature.model.PopMovie;
import com.revature.model.PopMovieList;



@Controller
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/popularmovies", consumes  = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
public class PopMovieControllerAlpha {
	
	private static final Logger logger = Logger.getLogger(PopMovieControllerAlpha.class);
	
	@Autowired
	private PopularMovies popularMovies;
	
	
	@Autowired
	public PopMovieControllerAlpha(PopularMovies popularMovies) {
		this.popularMovies = popularMovies;
		 
	}
	
	@GetMapping("/all")
	public PopMovieList findAllMovies() {
//		@RequestParam(value = "id") int popId,
//	    @RequestParam(value = "title") String title,
//	    @RequestParam(value = "genre_ids") List<PopMovie> genre,
//	    @RequestParam(value = "release_date") String releaseDate){
		logger.trace("Attempting to gather selected columns from the API:");
		return popularMovies.getPopMovieList();
	}
}
