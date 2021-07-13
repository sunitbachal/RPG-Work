package com.zensar.chatroom;

public class User {

	private String userName;
	private String city;

	@Override
	public String toString() {
		return "User [userName=" + userName + ", city=" + city + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
