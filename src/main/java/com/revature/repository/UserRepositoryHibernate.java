package com.revature.repository;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryHibernate implements UserRepository{
	
	private static Logger logger = Logger.getLogger(UserRepositoryHibernate.class);
	
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		logger.trace("Attempting to save a user");
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		logger.trace("Attempting to retrive a user by username");
		try {
			return(User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.ilike("username", username))
					.list()
					.get(0);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
		
	}

}
