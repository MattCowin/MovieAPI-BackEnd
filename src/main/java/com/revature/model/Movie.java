package com.revature.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie {

	
	@Id
	@Column(name="MOVIE_ID")
	private int id;					// Primary Key, movie's unique ID from the API
	
	//TODO link Foreign key
	@Column(name="USER_ID")
	private int userId;				// which user favorited this movie
	
	@Column(name="VOTE_AVERAGE")
	private double voteAverage;		// average score out of 10
	
	@Column(name="POPULARITY")
	private double populatiry;		// numerical score of popularity relative to other movies
	
	@Column(name="TITLE")
	private String title;			// name of movie
	
	//@Column(name="GENRES")			// don't store in DB, just call the genre api and search by movie's title
	//private ArrayList<String> genres;	// array of genre id's
	
	@Column(name="POSTER_URL")
	private String posterUrl;		// link to jpg of poster
	
	@Column(name="OVERVIEW")
	private String overview;		//synopsis of film
	

	//TODO implement the variables in the movie bean we want to store & have
	// 		hibernate manage for us.
	
	// Possible fields:
	// @JsonSetter above a setter, put key name from JSON in ("") so you can have a differently named variable/setter than the json key.
	
}
/*
{"page":1,"total_results":19806,"total_pages":991,"results":[{
"vote_count":3645,
"id":299534,
"video":false,
"vote_average":8.7,
"title":"Avengers: Endgame",
"popularity":487.806,
"poster_path":"\/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
"original_language":"en",
"original_title":"Avengers: Endgame",
"genre_ids":[12,878,28],
"backdrop_path":"\/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg","adult":false,
"overview":"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, 
Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order 
to the universe once and for all, no matter what consequences may be in store.","release_date":"2019-04-24"}
*/
