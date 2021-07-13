package com.zensar.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("Inside setter setTitle() method");
	}

	public LifeCycleBean() {
		System.out.println("Inside LifeCycleBean() Default Constructor");
	}

	public LifeCycleBean(String title) {
		this.title = title;
		System.out.println("Inside LifeCycleBean(title) Constructor");
	}

	@Override
	public String toString() {
		return "LifeCycleBean [title=" + title + "]";
	}

	public void setBeanName(String name) {
		System.out.println("Inside setBeanName() method");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet() method from InitializingBean interface");
	}

	public void myInitMethod() {
		System.out.println("Inside myInitMethod() method from bean's init-method attribute");
	}

	public void destroy() throws Exception {
		System.out.println("Inside destroy() method from DisposableBean");

	}

	public void myDestroyMethod() {
		System.out.println("Inside myDestroyMethod() method from bean's destroy-method attribute");
	}

}
