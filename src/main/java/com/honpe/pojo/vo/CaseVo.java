package com.honpe.pojo.vo;

import java.util.List;

import com.honpe.po.Content;
import com.honpe.po.ContentCategory;

public class CaseVo {

	private ContentCategory category;
	private List<Content> contents;
	
	public CaseVo(ContentCategory category, List<Content> contents) {
		super();
		this.category = category;
		this.contents = contents;
	}

	public final ContentCategory getCategory() {
		return category;
	}

	public final void setCategory(ContentCategory category) {
		this.category = category;
	}

	public final List<Content> getContents() {
		return contents;
	}

	public final void setContents(List<Content> contents) {
		this.contents = contents;
	}
}
