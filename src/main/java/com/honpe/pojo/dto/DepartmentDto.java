package com.honpe.pojo.dto;

import java.util.List;

import com.honpe.po.SysDepartment;

public class DepartmentDto {
	private SysDepartment department;
	private List<SysDepartment> departments;

	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDto(SysDepartment department, List<SysDepartment> departments) {
		super();
		this.department = department;
		this.departments = departments;
	}

	public final SysDepartment getDepartment() {
		return department;
	}

	public final void setDepartment(SysDepartment department) {
		this.department = department;
	}

	public final List<SysDepartment> getDepartments() {
		return departments;
	}

	public final void setDepartments(List<SysDepartment> departments) {
		this.departments = departments;
	}
}
