package com.honpe.department.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.department.service.DepartmentService;
import com.honpe.mapper.SysDepartmentMapper;
import com.honpe.po.SysDepartment;
import com.honpe.po.SysDepartmentExample;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private SysDepartmentMapper sysDepartmentMapper;
	private final int DEPARTMENT_TOP_PARENT = 0;
	private final byte IS_DELETE = 1;

	@Override
	public List<SysDepartment> findAllNotParent() {
		SysDepartmentExample sysDepartmentExample = new SysDepartmentExample();
		sysDepartmentExample.createCriteria().andParentIdNotEqualTo(DEPARTMENT_TOP_PARENT)
				.andIsDeleteNotEqualTo(IS_DELETE);
		List<SysDepartment> departments = sysDepartmentMapper.selectByExample(sysDepartmentExample);
		return departments;
	}

	@Override
	public List<SysDepartment> findAllByParentId(Integer parentId) {
		SysDepartmentExample departmentExample = new SysDepartmentExample();
		departmentExample.createCriteria().andParentIdEqualTo(parentId).andIsDeleteNotEqualTo(IS_DELETE);
		return sysDepartmentMapper.selectByExample(departmentExample);
	}

	@Override
	public void saveDepartment(SysDepartment department) {
		if (department.getId() != null) {
			department.setUpdateTime(new Date());
			sysDepartmentMapper.updateByPrimaryKeySelective(department);
		} else {
			department.setCreateTime(new Date());
			sysDepartmentMapper.insertSelective(department);
		}
	}

	@Override
	public SysDepartment findById(Integer id) {
		return sysDepartmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Integer id) {
		SysDepartment department = new SysDepartment();
		department.setId(id);
		department.setIsDelete(IS_DELETE);
		sysDepartmentMapper.updateByPrimaryKeySelective(department);
	}
}
