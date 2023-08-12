package com.SpringBootCURDApplication.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	
		private int userid;
		private String username;
		private String password;
		private boolean enable;
		
		@Id
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
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
		public boolean getEnable() {
			return enable;
		}
		public void setEnable(boolean enable) {
			this.enable = enable;
		}
		
		public Users(int userid, String username, String password, boolean enable) {
			super();
			this.userid = userid;
			this.username = username;
			this.password = password;
			this.enable = enable;
		}
		
		public Users() {
			super();
		}
		
	}

