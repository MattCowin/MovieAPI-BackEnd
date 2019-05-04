package com.revature.rest;

import java.util.List;

import com.revature.model.PopMovie;



public interface PopMovieController {
	
	List<PopMovie> findAllMovies();
}
