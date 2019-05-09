package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MOVIE")	
@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie {
	
	private static Logger logger = Logger.getLogger(Movie.class);
	
	@Column
	private String adult;
	@Column
	private String backdrop_path;
	//private Collection belongs_to_collection;	
	@Column
	private String budget;
	//private ArrayList<Genres> genres;
	@Column
	private String homepage;
	//@Id			// how to handle multiple users adding the same movie?
	@Column
	private int id; //   <== PRIMARY KEY. Movie ID
	@Column
	private String imdb_id;
	@Column
	private String original_language;
	@Column
	private String original_title;
	@Column(length=500)
	private String overview;
	@Column
	private Double popularity;
	@Column
	private String poster_path;
	//private ArrayList<ProdCompanies> production_companies;
	//private ArrayList<ProdCountries> production_countries;
	@Column
	private String release_date;
	@Column
	private long revenue;
	@Column
	private int runtime;
	//private ArrayList<SpokenLanguages> spoken_languages;
	@Column
	private String status;
	@Column
	private String tagline;
	@Column
	private String title;
	@Column
	private boolean video;
	@Column
	private double vote_average;
	@Column
	private int vote_count;
	
	// CURRENTLY NO CONSTRUCTORS - DEFAULT CONSTRUCTOR ONLY
	
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		logger.trace("*** Setting Original_Title " + original_title);
		this.original_title = original_title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Double getPopularity() {
		return popularity;
	}
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public long getRevenue() {
		return revenue;
	}
	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adult == null) ? 0 : adult.hashCode());
		result = prime * result + ((backdrop_path == null) ? 0 : backdrop_path.hashCode());
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + id;
		result = prime * result + imdb_id;
		result = prime * result + ((original_language == null) ? 0 : original_language.hashCode());
		result = prime * result + ((original_title == null) ? 0 : original_title.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((popularity == null) ? 0 : popularity.hashCode());
		result = prime * result + ((poster_path == null) ? 0 : poster_path.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + (int) (revenue ^ (revenue >>> 32));
		result = prime * result + runtime;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tagline == null) ? 0 : tagline.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (video ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(vote_average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vote_count;
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
		if (adult == null) {
			if (other.adult != null)
				return false;
		} else if (!adult.equals(other.adult))
			return false;
		if (backdrop_path == null) {
			if (other.backdrop_path != null)
				return false;
		} else if (!backdrop_path.equals(other.backdrop_path))
			return false;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (id != other.id)
			return false;
		if (imdb_id != other.imdb_id)
			return false;
		if (original_language == null) {
			if (other.original_language != null)
				return false;
		} else if (!original_language.equals(other.original_language))
			return false;
		if (original_title == null) {
			if (other.original_title != null)
				return false;
		} else if (!original_title.equals(other.original_title))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (popularity == null) {
			if (other.popularity != null)
				return false;
		} else if (!popularity.equals(other.popularity))
			return false;
		if (poster_path == null) {
			if (other.poster_path != null)
				return false;
		} else if (!poster_path.equals(other.poster_path))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (revenue != other.revenue)
			return false;
		if (runtime != other.runtime)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tagline == null) {
			if (other.tagline != null)
				return false;
		} else if (!tagline.equals(other.tagline))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (video != other.video)
			return false;
		if (Double.doubleToLongBits(vote_average) != Double.doubleToLongBits(other.vote_average))
			return false;
		if (vote_count != other.vote_count)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movie [adult=" + adult + ", backdrop_path=" + backdrop_path + ", budget=" + budget + ", homepage="
				+ homepage + ", id=" + id + ", imdb_id=" + imdb_id + ", original_language=" + original_language
				+ ", original_title=" + original_title + ", overview=" + overview + ", popularity=" + popularity
				+ ", poster_path=" + poster_path + ", release_date=" + release_date + ", revenue=" + revenue
				+ ", runtime=" + runtime + ", status=" + status + ", tagline=" + tagline + ", title=" + title
				+ ", video=" + video + ", vote_average=" + vote_average + ", vote_count=" + vote_count + "]";
	}

	
	
	

}
/*
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
