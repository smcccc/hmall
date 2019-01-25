package com.honpe.pojo.vo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TreeResult {
	private Long id;
	private String text;

	@JsonInclude(Include.NON_NULL)
	private Map<String, Object> state;
	@JsonInclude(Include.NON_NULL)
	private List<TreeResult> children;

	public TreeResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeResult(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getText() {
		return text;
	}

	public final void setText(String text) {
		this.text = text;
	}

	public final Map<String, Object> getState() {
		return state;
	}

	public final void setState(Map<String, Object> state) {
		this.state = state;
	}

	public final List<TreeResult> getChildren() {
		return children;
	}

	public final void setChildren(List<TreeResult> children) {
		this.children = children;
	}
}
