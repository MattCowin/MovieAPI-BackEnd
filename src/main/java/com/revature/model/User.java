package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
		
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userDataSequence")
		@SequenceGenerator(name="userDataSequence", sequenceName="USER", allocationSize=1)
		@Column(name="USER_ID")
		private int id;
		@Column(name="USERNAME")
		private String username;
		@Column(name="PASSWORD")
		private String password;
		
		public User() {
			super();
			
		}

		public User(int userId, String username, String password) {
			super();
			this.id = userId;
			this.username = username;
			this.password = password;
		}

		public int getUserId() {
			return id;
		}

		public void setUserId(int userId) {
			this.id = userId;
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
		public String toString() {
			return "User [userId=" + id + ", username=" + username + ", password=" + password + "]";
		}
		
		
}
