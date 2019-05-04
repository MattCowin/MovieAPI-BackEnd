package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PopMovie {
	
	@Id
	@Column(name="id")
	private int popId;
	@Column(name="title")
	private String title;
	@Column(name="genre_ids")
	private List<PopMovie> genre = new ArrayList<>();
	@Column(name="release_date")
	private String releaseDate;
	
	public PopMovie() {
		
	}

	public PopMovie(int popId, String title, ArrayList<PopMovie> genre, String releaseDate) {
		this.popId = popId;
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}

	public int getPopId() {
		return popId;
	}

	public void setPopId(int popId) {
		this.popId = popId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PopMovie> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<PopMovie> genre) {
		this.genre = genre;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "PopMovie [popId=" + popId + ", title=" + title + ", genre=" + genre + ", releaseDate=" + releaseDate
				+ "]";
	}
	
	
	
}
