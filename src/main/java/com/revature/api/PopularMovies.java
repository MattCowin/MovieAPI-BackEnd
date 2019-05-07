package com.revature.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.revature.model.PopMovie;
import com.revature.model.PopMovieList;

public interface PopularMovies {
	//PopMovieList getPopMovieList(PopMovie popMovie);
//	  List<PopMovie> getPopMovieList();
	  PopMovie getPopMovieList(PopMovie popmovie);
//	  PopMovieList getPopMovieList(PopMovie popmovie);
    //List<PopMovie> getPopMovieList();
	//PopMovie getByName();

}
