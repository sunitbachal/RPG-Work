package com.zensar.assignments;

public class DepartmentBean {

	private int departmentId;
	private String departmentName;

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	@Override
	public String toString() {
		return "DepartmentBean [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

}
