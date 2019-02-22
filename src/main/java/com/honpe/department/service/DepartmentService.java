package com.honpe.department.service;

import java.util.List;
import com.honpe.po.SysDepartment;
import com.honpe.pojo.dto.DepartmentDto;

public interface DepartmentService {

	List<DepartmentDto> findAll();

	List<SysDepartment> findAllByParentId(Integer parentId);

	void saveDepartment(SysDepartment department);

	SysDepartment findById(Integer id);

	void deleteById(Integer id);
}
