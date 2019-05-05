package com.revature.model;

import java.util.List;

public class PopMovieList {

	private List<PopMovie> popMovieList;
	
	public PopMovieList() {
		
	}

	public PopMovieList(List<PopMovie> popMovieList) {
		super();
		this.popMovieList = popMovieList;
	}

	public List<PopMovie> getPopMovieList() {
		return popMovieList;
	}

	public void setPopMovieList(List<PopMovie> popMovieList) {
		this.popMovieList = popMovieList;
	}
	
	
	
}


