package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Movie;

//com.revature.repository = data access layer
@Repository("movieRepository")
@Transactional
public class MovieRepositoryHibernate implements MovieRepository {

	@Override
	public void save(Movie movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
