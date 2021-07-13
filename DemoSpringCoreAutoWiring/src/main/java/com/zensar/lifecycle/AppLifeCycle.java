package com.zensar.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLifeCycle {
	public static void main(String[] args) {
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("beanlifecycle.xml");
		LifeCycleBean bean = (LifeCycleBean) iocContainer.getBean("lifeCycleBean");
		System.out.println(bean);
	}
}
