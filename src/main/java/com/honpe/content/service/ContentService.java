package com.honpe.content.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.honpe.po.Content;
import com.honpe.po.ContentWithBLOBs;
import com.honpe.pojo.ext.ContentExt;

public interface ContentService {
	PageInfo<ContentExt> findAllByCategoryId(Integer page, Integer pageSize, Long categoryId, Boolean display,
			Boolean indexDisplay);

	void deleteById(Long id);

	Boolean changeDisplayById(Long id);

	Boolean changeIndexDisplayById(Long id);

	void saveContent(ContentWithBLOBs content);

	ContentWithBLOBs findById(Long id);

	List<Content> findAllByCategoryId(Long categoryId, Boolean display);

	ContentWithBLOBs findOneByCategoryId(Long categoryId, Boolean display);
}
