package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
		
		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userDataSequence")
		@SequenceGenerator(name="userDataSequence", sequenceName="USERS", allocationSize=1)
		@Column(name="USER_ID")
		private int userId;
		@Column(name="USERNAME")
		private String username;
		@Column(name="PASSWORD")
		private String password;
		
		public Users() {
			super();
			
		}

		public Users(int userId, String username, String password) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
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
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
		}
		
		
}
