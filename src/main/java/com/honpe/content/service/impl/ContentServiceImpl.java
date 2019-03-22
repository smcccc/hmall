package com.honpe.content.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.content.service.ContentService;
import com.honpe.mapper.ContentMapper;
import com.honpe.po.Content;
import com.honpe.po.ContentExample;
import com.honpe.po.ContentExample.Criteria;
import com.honpe.pojo.ext.ContentExt;
import com.honpe.po.ContentWithBLOBs;

@Service
@Transactional
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;

	@Override
	public PageInfo<ContentExt> findAllByCategoryId(Integer page, Integer pageSize, Long categoryId, Boolean display,
			Boolean indexDisplay) {
		PageHelper.startPage(page, pageSize);
		List<ContentExt> contentExts = contentMapper.selectByConditions(categoryId, display, indexDisplay);
		return new PageInfo<ContentExt>(contentExts);
	}
	
	
	
	@Override
	public void deleteById(Long id) {
		contentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Boolean changeDisplayById(Long id) {
		ContentWithBLOBs content = contentMapper.selectByPrimaryKey(id);
		content.setDisplay(!content.getDisplay());
		contentMapper.updateByPrimaryKeySelective(content);
		return content.getDisplay();
	}

	@Override
	public Boolean changeIndexDisplayById(Long id) {
		ContentWithBLOBs content = contentMapper.selectByPrimaryKey(id);
		content.setIndexDisplay(!content.getIndexDisplay());
		contentMapper.updateByPrimaryKeySelective(content);
		return content.getIndexDisplay();
	}

	@Override
	public void saveContent(ContentWithBLOBs content) {
		if (content.getId() == null) {
			content.setCreateTime(new Date());
			contentMapper.insertSelective(content);
			content.setSequence(content.getId());
			contentMapper.updateByPrimaryKeySelective(content);
		} else {
			content.setUpdateTime(new Date());
			contentMapper.updateByPrimaryKeySelective(content);
		}
	}

	@Override
	public ContentWithBLOBs findById(Long id) {
		return contentMapper.selectByPrimaryKey(id);
	}

	private ContentExample initExample(Long categoryId, Boolean display, Boolean indexDispaly) {
		ContentExample contentExample = new ContentExample();
		contentExample.setOrderByClause("sequence DESC");
		Criteria criteria = contentExample.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		if (display != null)
			criteria.andDisplayEqualTo(display);
		if (indexDispaly != null)
			criteria.andIndexDisplayEqualTo(indexDispaly);
		return contentExample;
	}

	@Override
	public List<Content> findAllByCategoryId(Long categoryId, Boolean display, Boolean indexDispaly) {
		ContentExample contentExample = initExample(categoryId, display, indexDispaly);
		List<Content> contents = contentMapper.selectByExample(contentExample);
		return contents;
	}

	@Override
	public ContentWithBLOBs findOneByCategoryId(Long categoryId, Boolean display) {
		ContentExample contentExample = initExample(categoryId, display, null);
		List<ContentWithBLOBs> contents = contentMapper.selectByExampleWithBLOBs(contentExample);
		if (contents != null && contents.size() > 0)
			return contents.get(0);
		return null;
	}
}
