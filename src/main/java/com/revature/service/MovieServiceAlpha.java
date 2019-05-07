package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Movie;
import com.revature.repository.MovieRepository;

// Known by William as "MovieServiceImpl", the Alpha is an alternate notation for implementations.
// com.revature.service = server layer (java business logic)
@Service("movieService")
public class MovieServiceAlpha implements MovieService{
	private static Logger logger = Logger.getLogger(UserServiceAlpha.class);
	
	@Autowired
	private MovieRepository movieRepository;
	
	public MovieServiceAlpha() {} 

	public MovieServiceAlpha(MovieService movieRepository) {
		this.movieRepository = movieRepository;
		//wait are these constructors necessary? We already autowired...
		// TODO figure this out tomorrow.
	}

	@Override
	public List<Movie> getAllMovies() {
		return null;
	}

	@Override
	public Movie getMovie(String title) {
		return movieRepository.findByTitle(title);

	}

	@Override
	public boolean registerMovie(Movie movie) {
		movieRepository.save(movie);
		return movie.getId() !=0;
	}
	
}
