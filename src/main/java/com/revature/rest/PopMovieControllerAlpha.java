package com.revature.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.api.PopularMovies;
import com.revature.model.PopMovie;
import com.revature.repository.PopMovieRepository;


@Controller
@RequestMapping("popMovie")
public class PopMovieControllerAlpha {
	
	private static final Logger logger = Logger.getLogger(PopMovieControllerAlpha.class);
	
	@Autowired
	private PopularMovies popularMovies;
	private PopMovieRepository popMovieRepository;
	
	@Autowired
	public PopMovieControllerAlpha(PopMovieRepository popMovieRepository) {
		this.popMovieRepository = popMovieRepository;
		 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<PopMovie> findAllMovies(
		@RequestParam(value = "id") int popId,
	    @RequestParam(value = "title") String title,
	    @RequestParam(value = "genre_ids") List<PopMovie> genre,
	    @RequestParam(value = "release_date") String releaseDate){
		logger.trace("Attempting to gather selected columns from the API:");
		return popMovieRepository.findAll();
	}
}
