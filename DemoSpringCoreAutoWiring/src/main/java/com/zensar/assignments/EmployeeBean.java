package com.zensar.assignments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeBean {

	private String name;

	@Autowired
	@Qualifier(value = "department")
	private DepartmentBean department;

	public EmployeeBean(String name, DepartmentBean department) {
		this.name = name;
		this.department = department;
	}

	public EmployeeBean() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}

	public DepartmentBean getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "EmployeeBean [name=" + name + ", department=" + department + "]";
	}

}
