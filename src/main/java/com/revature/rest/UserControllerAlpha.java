package com.revature.rest;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WENT_WRONG;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ajax.ClientMessage;
import com.revature.model.Movie;
import com.revature.model.Users;
import com.revature.repository.UserRepository;
import com.revature.service.MovieService;
import com.revature.service.UserService;
@RestController("userController")
@CrossOrigin(origins = "*")
public class UserControllerAlpha implements UserController{
	
	private static Logger logger = Logger.getLogger(UserControllerAlpha.class);
	@Autowired
	private UserService userService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public ClientMessage registerUser(@RequestBody Users user) {
		logger.trace("Registering a new user " + user);
		return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WENT_WRONG;
	}

	@PostMapping("/findUser")
	public Users findUser(@RequestBody Users user, HttpServletRequest request) {
		logger.trace("Finding user " + user);
		request.getSession();
		return userService.getUser(user.getUsername());
	}
/*
	@PostMapping("/findUserId")
	public Users findUserById(@RequestBody Users user, HttpServletRequest request) {
		logger.trace("Finding user " + user);
		request.getSession();
		return userService.getUserById(user.getUserId());
	}
*/
	//	GET /findUser??userId=
	@GetMapping(value="/findUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users findUserById(@RequestParam("userId") Integer userId) {
		logger.trace("*** Finding user by ID " + userId);
		return userService.getUserById(userId);
	}
			
			
	@PostMapping(value="/favorite/{id}")
	public boolean addFavoriteToUser(@PathVariable("id") Integer id, @RequestBody Movie movie) {
		Users user = userService.getUserById(id); 										//get info of current user
		
		if (user!=null) {
			logger.trace("*** User Exists, begin search to add movie. User = " + user);
			boolean movieExistsInDB = false; 											//set for later
			List<Movie> allMovies = movieService.getAllMovies();						//get movies currently in our DB
			
			if (movie.getId()!=0) {		//if id isn't set it should default to 0.		// if RequestBody wasn't empty (null)
				for (Movie m : allMovies) {
					logger.trace("*** Looking in DB for movie id " + movie.getId() + "current movie in for loop is " + m.getId());
					if(m.getId() == movie.getId()) {									// create link from user to fav movie when found
						logger.trace("*** Movie found, adding favorite movieId = " + m.getId());
						movieExistsInDB = true;
						movie = m;
						break;
					}
				}
			}
			if (!movieExistsInDB) {														//add movie to DB if it's not there yet
				logger.trace("*** Could not find movie in DB yet, adding it now.");
				movieService.registerMovie(movie);	
			}
			logger.trace("*** Adding favorite " + movie + "to user " + user);
			user.addFavoriteMovies(movie);												//add this Movie to user's List<Movie> of favs
			return userRepository.updateFavorites(user);
		}
		return false;

	}

}
