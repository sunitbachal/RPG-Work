package com.zensar.chatroom;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChatRoom {

	private String chatRoomName;
	private Set<User> users;
	private Map<User, String> messages;
	private List<String> admins;

	public ChatRoom() {
	}

	public ChatRoom(String chatRoomName, Set<User> users, Map<User, String> messages, List<String> admins) {
		super();
		this.chatRoomName = chatRoomName;
		this.users = users;
		this.messages = messages;
		this.admins = admins;
	}

	@Override
	public String toString() {
		return "ChatRoom [chatRoomName=" + chatRoomName + ", users=" + users + ", messages=" + messages + ", admins="
				+ admins + "]";
	}

	public void setAdmins(List<String> admins) {
		this.admins = admins;
	}

	public List<String> getAdmins() {
		return admins;
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Map<User, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<User, String> messages) {
		this.messages = messages;
	}
}
