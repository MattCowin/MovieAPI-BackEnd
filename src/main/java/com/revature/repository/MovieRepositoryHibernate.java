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

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findAll() {
		try {
			return (List<Movie>) sessionFactory.getCurrentSession().createCriteria(Movie.class)
					.list();
			
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public Movie findByTitle(String title) {
		logger.trace("*** Attempting to retrive a movie by title");
		try {
			return(Movie) sessionFactory.getCurrentSession().createCriteria(Movie.class)
					.add(Restrictions.ilike("title", title))
					.list()
					.get(0);
		}catch(IndexOutOfBoundsException e) {
			logger.trace("***No movie found matching title " + title);
			return null;
		}
	}

	@Override
	public Movie findMovieById(int movieId) {
		logger.trace("*** Attempting to retrive a movie by id");
		try {
			return (Movie) sessionFactory.getCurrentSession().createCriteria(Movie.class)
					.add(Restrictions.eq("id", movieId))
					.list()
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			logger.trace("***No movie found matching id " + movieId);
			return null;
		}
		
	}

	
}
