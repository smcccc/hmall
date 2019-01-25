package com.honpe.department.service;

import java.util.List;

import com.honpe.po.SysDepartment;

public interface DepartmentService {
	List<SysDepartment> findAllNotParent();

	List<SysDepartment> findAllByParentId(Integer parentId);

	void saveDepartment(SysDepartment department);

	SysDepartment findById(Integer id);

	void deleteById(Integer id);
}
