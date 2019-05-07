package com.revature.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.model.PopMovie;
import com.revature.model.PopMovieList;



public interface PopMovieController {
	ResponseEntity<PopMovieList> findAllMovies(PopMovie popmovie);
	//List<PopMovie> findAllMovies();
	 PopMovieList getPopMovieList(PopMovie popmovie);
}
