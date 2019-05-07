package com.revature.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Movie;
import com.revature.model.Users;

//com.revature.repository = data access layer
@Repository("movieRepository")
@Transactional
public class MovieRepositoryHibernate implements MovieRepository {

	private static Logger logger = Logger.getLogger(UserRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Movie movie) {
		logger.trace("*** Attempting to save a movie");
		sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie findByTitle(String title) {
		logger.trace("*** Attempting to retrive a movie by title");
		try {
			return(Movie) sessionFactory.getCurrentSession().createCriteria(Users.class)
					.add(Restrictions.ilike("title", title))
					.list()
					.get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

}
