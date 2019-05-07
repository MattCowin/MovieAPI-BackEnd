package com.revature.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.api.PopularMovies;
import com.revature.model.PopMovie;
import com.revature.model.PopMovieList;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/popularmovies", consumes  = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
public class PopMovieControllerAlpha {
	
	private static final Logger logger = Logger.getLogger(PopMovieControllerAlpha.class);
	
	@Autowired
	private PopularMovies popularMovies;
	
	
	
	
//	@GetMapping("/all")
//	public ResponseEntity<PopMovie> findAllMovies() {
////		@RequestParam(value = "id") int popId,
////	    @RequestParam(value = "title") String title,
////	    @RequestParam(value = "genre_ids") List<PopMovie> genre,
////	    @RequestParam(value = "release_date") String releaseDate){
//		logger.trace("Attempting to gather selected columns from the API:");
//		return new ResponseEntity<PopMovie>(new PopMovie(popularMovies.getPopMovieList(PopMovie popmovie))), HttpStatus.OK);
//	}
	
	@GetMapping("/all")
	public PopMovie findAllMovies() {
		logger.trace("Attempting to gather selected columns from the API:");
		return new PopMovie(PopMovieList , HttpStatus.OK);
	}
}
