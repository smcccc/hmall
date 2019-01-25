package com.honpe.content.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.constant.Constant;
import com.honpe.content.service.CategoryService;
import com.honpe.content.service.ContentService;
import com.honpe.mapper.ContentCategoryMapper;
import com.honpe.po.Content;
import com.honpe.po.ContentCategory;
import com.honpe.po.ContentCategoryExample;
import com.honpe.po.ContentCategoryExample.Criteria;
import com.honpe.pojo.dto.CategoryDto;
import com.honpe.pojo.vo.TreeResult;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ContentCategoryMapper contentCategoryMapper;
	@Autowired
	private ContentService contentService;

	@Override
	public TreeResult findAll() {
		ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
		contentCategoryExample.setOrderByClause("sequence ASC");
		contentCategoryExample.createCriteria().andIsDeleteEqualTo(false)
				.andParentIdEqualTo(Constant.CategoryConst.TOP_PARENT);
		List<ContentCategory> categories = contentCategoryMapper.selectByExample(contentCategoryExample);
		TreeResult tree = new TreeResult(0L, "内容类别");
		if (categories != null && categories.size() > 0) {
			HashMap<String, Object> state = new HashMap<>();
			state.put("opened", true);
			tree.setState(state);
			recursionAll(categories, tree);
		}
		return tree;
	}

	private void recursionAll(List<ContentCategory> categories, TreeResult treeResult) {
		LinkedList<TreeResult> children = new LinkedList<>();
		for (ContentCategory category : categories) {
			TreeResult ts = new TreeResult(category.getId(), category.getTitle());
			if (category.getIsParent()) {
				List<ContentCategory> contentCategories = findByParentId(category.getId());
				if (contentCategories != null && contentCategories.size() > 0) {
					Map<String, Object> state = new HashMap<>(1);
					state.put("opened", true);
					ts.setState(state);
					recursionAll(contentCategories, ts);
				}
			}
			children.add(ts);
		}
		treeResult.setChildren(children);
	}

	private List<ContentCategory> findByParentId(Long parentId) {
		ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
		contentCategoryExample.setOrderByClause("sequence ASC");
		contentCategoryExample.createCriteria().andParentIdEqualTo(parentId).andIsDeleteEqualTo(false);
		List<ContentCategory> contentCategories = contentCategoryMapper.selectByExample(contentCategoryExample);
		return contentCategories;
	}

	@Override
	public void deleteCategoryById(Long id) {
		ContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		contentCategory.setId(id);
		contentCategory.setIsDelete(true);
		contentCategoryMapper.updateByPrimaryKeySelective(contentCategory);
		if (!contentCategory.getIsParent()) {
			List<Content> contents = contentService.findAllByCategoryId(contentCategory.getId(), null);
			if (contents != null && contents.size() > 0) {
				contents.forEach(content -> contentService.deleteById(content.getId()));
			}
		}
		if (contentCategory.getParentId() != Constant.CategoryConst.TOP_PARENT) {
			changeParentToNoIsParent(contentCategory.getParentId());
		}
	}

	private void changeParentToNoIsParent(Long parentId) {
		ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
		contentCategoryExample.createCriteria().andIsDeleteEqualTo(false).andParentIdEqualTo(parentId);
		List<ContentCategory> categories = contentCategoryMapper.selectByExample(contentCategoryExample);

		if (categories == null || categories.size() == 0) {
			ContentCategory parent = new ContentCategory();
			parent.setId(parentId);
			parent.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKeySelective(parent);
		}
	}

	@Override
	public void editCategory(ContentCategory category) {
		category.setUpdateTime(new Date());
		contentCategoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public Long addCategory(ContentCategory category) {
		category.setCreateTime(new Date());
		contentCategoryMapper.insertSelective(category);
		if (Constant.CategoryConst.TOP_PARENT != category.getParentId()) {
			ContentCategory parent = findById(category.getParentId());
			if (parent != null && !parent.getIsParent()) {
				parent.setIsParent(true);
				editCategory(parent);
			}
		}
		return category.getId();
	}

	@Override
	public ContentCategory findById(Long id) {
		return contentCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ContentCategory> findAllChildCategory() {
		ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
		contentCategoryExample.setOrderByClause("sequence ASC");
		contentCategoryExample.createCriteria().andIsDeleteEqualTo(false).andIsParentEqualTo(false);
		return contentCategoryMapper.selectByExample(contentCategoryExample);
	}

	@Override
	public Boolean isHasChild(Long parentId) {
		ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
		contentCategoryExample.createCriteria().andParentIdEqualTo(parentId).andIsDeleteEqualTo(false);
		List<ContentCategory> children = contentCategoryMapper.selectByExample(contentCategoryExample);
		return children != null && children.size() > 0;
	}

	@Override
	public List<ContentCategory> findChilrenById(Long id) {
		return findChildren(id, false);
	}

	private List<ContentCategory> findChildren(Long id, Boolean isParent) {
		ContentCategory parent = contentCategoryMapper.selectByPrimaryKey(id);
		List<ContentCategory> categories = null;
		if (parent != null) {
			ContentCategoryExample contentCategoryExample = new ContentCategoryExample();
			contentCategoryExample.setOrderByClause("sequence ASC");
			contentCategoryExample.createCriteria().andParentIdEqualTo(parent.getId()).andIsDeleteEqualTo(false)
					.andIsParentEqualTo(isParent);

			categories = contentCategoryMapper.selectByExample(contentCategoryExample);
		}
		return categories;
	}

	@Override
	public List<CategoryDto> findAllchilrenById(Long id) {
		List<ContentCategory> categories = findChildren(id, true);
		List<CategoryDto> linkedList = new LinkedList<>();
		if (categories != null && categories.size() > 0) {
			for (ContentCategory category : categories) {
				List<ContentCategory> children = findChildren(category.getId(), false);
				if (children != null && children.size() > 0) {
					CategoryDto categoryDto = new CategoryDto(category, children);
					linkedList.add(categoryDto);
				}
			}
		}
		return linkedList;
	}

	@Override
	public void dragAnddropCategory(Long oldParent, Long next, ContentCategory category) {
		contentCategoryMapper.updateByPrimaryKeySelective(category);
		ContentCategory parent = new ContentCategory();
		parent.setId(category.getParentId());
		parent.setIsParent(true);
		contentCategoryMapper.updateByPrimaryKeySelective(parent);
		changeParentToNoIsParent(oldParent);
		if (next != null) {
			ContentCategory nextCategory = new ContentCategory();
			nextCategory.setId(next);
			nextCategory.setSequence(category.getSequence() + 1);
			contentCategoryMapper.updateByPrimaryKeySelective(nextCategory);
		}
	}
}
