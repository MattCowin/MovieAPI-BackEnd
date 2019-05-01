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
		public User(int id, String username, String password) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
			return "UserData [id=" + id + ", username=" + username + ", password=" + password + "]";
		}
		
		
		
}
