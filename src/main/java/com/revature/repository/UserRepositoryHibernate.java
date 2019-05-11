package com.revature.repository;



import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.revature.model.Users;



@Repository("userRepository")
@Transactional
public class UserRepositoryHibernate implements UserRepository{
	
	private static Logger logger = Logger.getLogger(UserRepositoryHibernate.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Users user) {
		logger.trace("Attempting to save a user");
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public Users findByUsername(String username) {
		logger.trace("*** Attempting to retrive a user by username=" + username);
		try {
			return(Users) sessionFactory.getCurrentSession().createCriteria(Users.class)
					.add(Restrictions.ilike("username", username))
					.list()
					.get(0);
		}catch(IndexOutOfBoundsException e) {
			logger.trace("*** FAILED to retrive a user by username=" + username);
			return null;
		}
		
	}

	@Override
	public Users findByUserId(int id) {
		logger.trace("*** Attempting to retrive a user by id= " + id);
		try {
			return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class)
					.add(Restrictions.eq("userId", id)) 
					.list()
					.get(0);
		}catch(IndexOutOfBoundsException e) {
			logger.trace("*** failed to retrive a user by id= " + id);
			return null;
		}
	}
	
	@Override
	public boolean updateFavorites(Users updatedUser) {
		
		Session mySession = sessionFactory.getCurrentSession();
		Users userToBeUpdated = null;
		
		userToBeUpdated = (Users) mySession.get(Users.class, updatedUser.getUserId());
		logger.trace("*** Updating user favorites to " + userToBeUpdated.getFavoriteMovies());
		
		if(updatedUser.getFavoriteMovies() != null) {
			logger.trace("*** Updating User " + userToBeUpdated.getUserId() + " favorites to " + updatedUser.getFavoriteMovies());
			userToBeUpdated.setFavoriteMovies(updatedUser.getFavoriteMovies());
			return true;
		}
		
		return false;
		
	}
	

}
