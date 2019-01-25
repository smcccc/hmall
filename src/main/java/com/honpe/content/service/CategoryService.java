package com.honpe.content.service;

import java.util.List;
import com.honpe.po.ContentCategory;
import com.honpe.pojo.dto.CategoryDto;
import com.honpe.pojo.vo.TreeResult;

public interface CategoryService {

	TreeResult findAll();

	void deleteCategoryById(Long id);

	void editCategory(ContentCategory category);

	Long addCategory(ContentCategory category);

	ContentCategory findById(Long id);

	List<ContentCategory> findAllChildCategory();

	Boolean isHasChild(Long parentId);

	List<ContentCategory> findChilrenById(Long id);

	List<CategoryDto> findAllchilrenById(Long id);

	void dragAnddropCategory(Long oldParent, Long next, ContentCategory category);
}
