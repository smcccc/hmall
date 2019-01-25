package com.honpe.pojo.dto;

import java.util.List;

import com.honpe.po.ContentCategory;

public class CategoryDto {
	private ContentCategory category;
	private List<ContentCategory> categories;

	public CategoryDto(ContentCategory category, List<ContentCategory> categories) {
		super();
		this.category = category;
		this.categories = categories;
	}

	public final ContentCategory getCategory() {
		return category;
	}

	public final void setCategory(ContentCategory category) {
		this.category = category;
	}

	public final List<ContentCategory> getCategories() {
		return categories;
	}

	public final void setCategories(List<ContentCategory> categories) {
		this.categories = categories;
	}
}
