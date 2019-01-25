package com.honpe.account.service;

import java.util.List;

import com.honpe.po.YxAreaTable;

public interface AreaService {
	YxAreaTable findAreaById(Integer id);
	
	List<YxAreaTable> findAreaByParentId(Integer parentId);
}
