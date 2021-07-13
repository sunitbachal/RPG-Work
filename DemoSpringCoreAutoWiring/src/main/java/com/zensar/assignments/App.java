package com.zensar.assignments;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("assignments.xml");

		EmployeeBean emp= (EmployeeBean) iocContainer.getBean("emp");
		System.out.println(emp);
	}
}
