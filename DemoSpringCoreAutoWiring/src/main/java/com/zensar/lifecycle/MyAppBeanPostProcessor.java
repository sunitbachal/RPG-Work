package com.zensar.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyAppBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println(
				"\t Inside postProcessBeforeInitialization: " + beanName + "  from BeanPostProcessor interface");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("\t postProcessAfterInitialization: " + beanName + "  from BeanPostProcessor interface");
		if (bean instanceof LifeCycleBean) {
			LifeCycleBean lifeCycleBean = (LifeCycleBean) bean;
			//lifeCycleBean.setTitle("New title by PostProcerror");
		}
		return bean;
	}
}
