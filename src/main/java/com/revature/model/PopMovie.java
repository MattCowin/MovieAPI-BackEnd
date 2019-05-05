package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopMovie {
	
	@Column(name="vote_count")
	private int voteCount;
	@Id
	@Column(name="id")
	private int popId;
	@Column(name="video")
	private boolean video;
	@Column(name="vote_average")
	private double voteAverage;
	@Column(name="title")
	private String title;
	@Column(name="popularity")
	private double popularity;
	@Column(name="poster_path")
	private String posterPath;
	@Column(name="original_language")
	private String originalLanguage;
	@Column(name="original_title")
	private String originalTitle;
	@Column(name="genre_ids")
	private ArrayList<PopMovie> genre = new ArrayList<>();
	@Column(name="backdrop_path")
	private String backdropPath;
	@Column(name="adult")
	private boolean adult;
	@Column(name="overview")
	private String overview;
	@Column(name="release_date")
	private String releaseDate;
	
	public PopMovie() {
		
	}

	public PopMovie(int voteCount, int popId, boolean video, double voteAverage, String title, double popularity,
			String posterPath, String originalLanguage, String originalTitle, ArrayList<PopMovie> genre,
			String backdropPath, boolean adult, String overview, String releaseDate) {
		super();
		this.voteCount = voteCount;
		this.popId = popId;
		this.video = video;
		this.voteAverage = voteAverage;
		this.title = title;
		this.popularity = popularity;
		this.posterPath = posterPath;
		this.originalLanguage = originalLanguage;
		this.originalTitle = originalTitle;
		this.genre = genre;
		this.backdropPath = backdropPath;
		this.adult = adult;
		this.overview = overview;
		this.releaseDate = releaseDate;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public int getPopId() {
		return popId;
	}

	public void setPopId(int popId) {
		this.popId = popId;
	}

	public boolean isVideo() {
		return video;
	}

	public void setVideo(boolean video) {
		this.video = video;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public ArrayList<PopMovie> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<PopMovie> genre) {
		this.genre = genre;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "PopMovie [voteCount=" + voteCount + ", popId=" + popId + ", video=" + video + ", voteAverage="
				+ voteAverage + ", title=" + title + ", popularity=" + popularity + ", posterPath=" + posterPath
				+ ", originalLanguage=" + originalLanguage + ", originalTitle=" + originalTitle + ", genre=" + genre
				+ ", backdropPath=" + backdropPath + ", adult=" + adult + ", overview=" + overview + ", releaseDate="
				+ releaseDate + "]";
	}

	
	
	
}
