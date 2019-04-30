package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie {

	// Primary Key, movie's unique ID from the API
	@Id
	@Column(name="M_ID")
	private int id;

	//TODO implement the variables in the movie bean we want to store & have
	// 		hibernate manage for us.
	
	// Possible fields:
	// Movie Name
	// Movie Genre
	// Movie rating (?)
	
}
