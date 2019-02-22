package com.honpe.department.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.department.service.DepartmentService;
import com.honpe.mapper.SysDepartmentMapper;
import com.honpe.po.SysDepartment;
import com.honpe.po.SysDepartmentExample;
import com.honpe.pojo.dto.DepartmentDto;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private SysDepartmentMapper sysDepartmentMapper;
	private final int DEPARTMENT_TOP_PARENT = 0;

	@Override
	public List<DepartmentDto> findAll() {
		List<SysDepartment> parents = findAllByParentId(DEPARTMENT_TOP_PARENT);
		List<DepartmentDto> departments = null;
		if (parents != null && parents.size() > 0) {
			departments = new ArrayList<>();
			for (SysDepartment parent : parents) {
				List<SysDepartment> children = findAllByParentId(parent.getId());
				DepartmentDto department = new DepartmentDto(parent, children);
				departments.add(department);
			}
		}
		return departments;
	}

	@Override
	public List<SysDepartment> findAllByParentId(Integer parentId) {
		SysDepartmentExample departmentExample = new SysDepartmentExample();
		departmentExample.createCriteria().andParentIdEqualTo(parentId).andIsDeleteEqualTo(false);
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
		department.setIsDelete(true);
		sysDepartmentMapper.updateByPrimaryKeySelective(department);
	}
}
