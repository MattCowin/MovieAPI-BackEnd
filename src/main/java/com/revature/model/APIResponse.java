package com.revature.model;

import java.util.List;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class APIResponse {

	private int page;
	private List<Movie> results;
	private int total_pages;
	private int total_results;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public void addResults(Movie movie) {
		this.results.add(movie);
	}
	public List<Movie> getResults() {
		return results;
	}
	public void setResults(List<Movie> results) {
		this.results = results;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + page;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + total_pages;
		result = prime * result + total_results;
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
		APIResponse other = (APIResponse) obj;
		if (page != other.page)
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (total_pages != other.total_pages)
			return false;
		if (total_results != other.total_results)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "APIResponse [page=" + page + ", results=" + results + ", total_pages=" + total_pages
				+ ", total_results=" + total_results + "]";
	}
	
	
}
