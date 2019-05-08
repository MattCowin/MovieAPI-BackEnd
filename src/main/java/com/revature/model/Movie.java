package com.revature.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "MOVIE")		
public class Movie {
	// TODO clean up, make variable names match JSON names Exactly. Remake getter/setters
	// TODO @ManytoMany and @JoinTable annotations
	
	@Id
	@Column(name = "MOVIE_ID")
	private int id; // Primary Key, movie's unique ID from the API

	// TODO link Foreign key
	@Column(name = "USER_ID")
	private int userId; // which user favorited this movie. Not marshalled, add userId from session
						// data.
	// Use a join table, so movies only entered into the movie table once. Join table will be key:value for user and the movies they favorited.

	@Column(name = "VOTE_COUNT")
	private double voteCount;

	@Column(name = "VIDEO")
	private boolean video;

	@Column(name = "VOTE_AVERAGE")
	private double voteAverage; // average score out of 10

	@Column(name = "TITLE")
	private String title; // name of movie

	@Column(name = "POPULARITY")
	private double popularity; // numerical score of popularity relative to other movies

	@Column(name = "POSTER_PATH")
	private String posterPath; // link to jpg of poster

	@Column(name = "ORIGINAL_LANGUAGE")
	private String originalLanguage;

	@Column(name = "ORIGINAL_TITLE")
	private String originalTitle;

	// @Column(name="GENRES") // don't store in DB, just call the genre api and
	// search by movie's title
	private ArrayList<String> genres; // array of genre id's

	@Column(name = "BACKDROP_PATH")
	private String backdropPath;

	@Column(name = "OVERVIEW")
	private String overview; // synopsis of film

	public Movie() {
		super();
	}

	@JsonGetter("id")
	public int getId() {
		return id;
	}

	@JsonSetter("id")
	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@JsonGetter("vote_count")
	public double getVoteCount() {
		return voteCount;
	}

	@JsonSetter("vote_count")
	public void setVoteCount(double voteCount) {
		this.voteCount = voteCount;
	}

	@JsonGetter("video")
	public boolean isVideo() {
		return video;
	}

	@JsonSetter("video")
	public void setVideo(boolean video) {
		this.video = video;
	}

	@JsonGetter("vote_average")
	public double getVoteAverage() {
		return voteAverage;
	}

	@JsonSetter("vote_average")
	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	@JsonGetter("title")
	public String getTitle() {
		return title;
	}

	@JsonSetter("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonGetter("popularity")
	public double getPopularity() {
		return popularity;
	}

	@JsonSetter("popularity")
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	@JsonGetter("poster_path")
	public String getPosterPath() {
		return posterPath;
	}

	@JsonSetter("poster_path")
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	@JsonGetter("original_language")
	public String getOriginalLanguage() {
		return originalLanguage;
	}

	@JsonSetter("original_language")
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	@JsonGetter("original_title")
	public String getOriginalTitle() {
		return originalTitle;
	}

	@JsonSetter("original_title")
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public ArrayList<String> getGenres() { // can't marshal an array out of json directly to object??
		return genres;
	}

	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}

	@JsonGetter("backdrop_path")
	public String getBackdropPath() {
		return backdropPath;
	}

	@JsonSetter("backdrop_path")
	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	@JsonGetter("overview")
	public String getOverview() {
		return overview;
	}

	@JsonSetter("overview")
	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backdropPath == null) ? 0 : backdropPath.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + id;
		result = prime * result + ((originalLanguage == null) ? 0 : originalLanguage.hashCode());
		result = prime * result + ((originalTitle == null) ? 0 : originalTitle.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		long temp;
		temp = Double.doubleToLongBits(popularity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((posterPath == null) ? 0 : posterPath.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + userId;
		result = prime * result + (video ? 1231 : 1237);
		temp = Double.doubleToLongBits(voteAverage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(voteCount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (backdropPath == null) {
			if (other.backdropPath != null)
				return false;
		} else if (!backdropPath.equals(other.backdropPath))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
			return false;
		if (originalLanguage == null) {
			if (other.originalLanguage != null)
				return false;
		} else if (!originalLanguage.equals(other.originalLanguage))
			return false;
		if (originalTitle == null) {
			if (other.originalTitle != null)
				return false;
		} else if (!originalTitle.equals(other.originalTitle))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (Double.doubleToLongBits(popularity) != Double.doubleToLongBits(other.popularity))
			return false;
		if (posterPath == null) {
			if (other.posterPath != null)
				return false;
		} else if (!posterPath.equals(other.posterPath))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userId != other.userId)
			return false;
		if (video != other.video)
			return false;
		if (Double.doubleToLongBits(voteAverage) != Double.doubleToLongBits(other.voteAverage))
			return false;
		if (Double.doubleToLongBits(voteCount) != Double.doubleToLongBits(other.voteCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", userId=" + userId + ", voteCount=" + voteCount + ", video=" + video
				+ ", voteAverage=" + voteAverage + ", title=" + title + ", popularity=" + popularity + ", posterPath="
				+ posterPath + ", originalLanguage=" + originalLanguage + ", originalTitle=" + originalTitle
				+ ", genres=" + genres + ", backdropPath=" + backdropPath + ", overview=" + overview + "]";
	}

	// Possible fields:
	// @JsonSetter above a setter, put key name from JSON in ("") so you can have a
	// differently named variable/setter than the json key.

}
/*
{"page":1,"total_results":19806,"total_pages":991,"results":[
{
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
"overview":"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store., 
"release_date":"2019-04-24"
}
*/
