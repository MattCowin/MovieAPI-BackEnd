package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="nowPlaying")
public class NowPlaying {
		@Column
		private int voteCount;
		@Id
		@Column
		private long id;
		@Column
		private boolean video;
		@Column
		private double voteAverage;
		@Column
		private String title;
		@Column
		private double popularity;
		@Column
		private String posterPath;
		@Column
		private String originalLanguage;
		@Column
		private String originalTitle;
		@Column
		//private ArrayList<genre>genreIds;
		private String backdropPath;
		@Column
		private boolean adult;
		@Column
		private String overview;
		@Column
		private String releaseDate;
		
		public NowPlaying() {
			super();
			// TODO Auto-generated constructor stub
		}

		public NowPlaying(int voteCount, long id, boolean video, double voteAverage, String title, double popularity,
				String posterPath, String originalLanguage, String originalTitle, String backdropPath, boolean adult,
				String overview, String releaseDate) {
			super();
			this.voteCount = voteCount;
			this.id = id;
			this.video = video;
			this.voteAverage = voteAverage;
			this.title = title;
			this.popularity = popularity;
			this.posterPath = posterPath;
			this.originalLanguage = originalLanguage;
			this.originalTitle = originalTitle;
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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
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
			return "NowPlaying [voteCount=" + voteCount + ", id=" + id + ", video=" + video + ", voteAverage="
					+ voteAverage + ", title=" + title + ", popularity=" + popularity + ", posterPath=" + posterPath
					+ ", originalLanguage=" + originalLanguage + ", originalTitle=" + originalTitle + ", backdropPath="
					+ backdropPath + ", adult=" + adult + ", overview=" + overview + ", releaseDate=" + releaseDate
					+ "]";
		}
		
		
}



