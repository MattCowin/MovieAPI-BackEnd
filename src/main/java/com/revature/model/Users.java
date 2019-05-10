package com.revature.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="USERS")
public class Users {
		
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userDataSequence")
		@SequenceGenerator(name="userDataSequence", sequenceName="USERS_SEQ", allocationSize=1)
		@Column(name="userId")
		private int userId;
		@Column(name="USERNAME")
		private String username;
		@Column(name="PASSWORD")
		private String password;
		
		@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
		@JoinTable(name="user_favoritemovie_jt", joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="ID"))
		private List<Movie> favoriteMovies;
		
		public Users() {
			super();
			
		}

		public Users(int userId, String username, String password) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
		}
		

		public Users(int userId, String username, String password, List<Movie> favoriteMovies) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
			this.favoriteMovies = favoriteMovies;
		}

		public void addFavoriteMovies(Movie movie) {
			this.favoriteMovies.add(movie);
		}
		
		public List<Movie> getFavoriteMovies() {
			return favoriteMovies;
		}

		public void setFavoriteMovies(List<Movie> favoriteMovies) {
			this.favoriteMovies = favoriteMovies;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((favoriteMovies == null) ? 0 : favoriteMovies.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + userId;
			result = prime * result + ((username == null) ? 0 : username.hashCode());
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
			Users other = (Users) obj;
			if (favoriteMovies == null) {
				if (other.favoriteMovies != null)
					return false;
			} else if (!favoriteMovies.equals(other.favoriteMovies))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (userId != other.userId)
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", favoriteMovies="
					+ favoriteMovies + "]";
		}

		
		
		
		
		
}
