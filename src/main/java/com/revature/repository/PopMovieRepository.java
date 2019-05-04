package com.revature.repository;

import java.util.List;

import com.revature.model.PopMovie;

public interface PopMovieRepository {
	
		List<PopMovie> findAll();
		PopMovie findByTitle(String title);
}
