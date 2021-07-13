package com.zensar.DemoSpringCoreAutoWiring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AutoWiringApp {
	public static void main(String[] args) {
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("beans.xml");

		Order o = (Order) iocContainer.getBean("order");
		System.out.println(o);
	}
}
