package com.helpezee.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Secured")
public class Secured {
	
	private String username;
	private String password;
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
	

}
