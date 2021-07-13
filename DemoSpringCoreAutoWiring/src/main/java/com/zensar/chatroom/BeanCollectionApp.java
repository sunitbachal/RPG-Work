package com.zensar.chatroom;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCollectionApp {

	public static void main(String[] args) {
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("beancollections.xml");

		ChatRoom chatRoom=(ChatRoom) iocContainer.getBean("chatRoom");
		System.out.println(chatRoom);
	}

}
