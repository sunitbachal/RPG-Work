package com.zensar.DemoSpringCoreAutoWiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Order {

	@Autowired
	@Qualifier(value = "item11")
	private Item item;
	private String title;

	public Order() {
		System.out.println("Order clsss constructed");
	}

	public Order(Item item) {
		System.out.println("Order(item) clsss constructed");
		this.item = item;
	}

	public Order(Item item, String title)	 {
		super();
		this.item = item;
		this.title = title;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Order [item=" + item + ", title=" + title + "]";
	}

}
