package com.revature.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.PopMovie;
@Repository("popMovieRepository")
@Transactional
public class PopMovieRepositoryAlpha implements PopMovieRepository {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<PopMovie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopMovie findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
