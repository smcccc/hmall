package com.honpe.pojo.vo;

import java.util.List;

public class PageBean<T> {
	private int currentPage;// 当前页
	private long totalRecord;// 记录总数
	private int pageSize;// 每页显示记录数
	private int totalPage;// 总共页数
	private List<T> data;// 数据

	private int start;// 起始页
	private int end;// 终止页

	public PageBean() {

	}

	public PageBean(int currentPage, long totalRecord, int pageSize, List<T> data) {
		super();
		this.data = data;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.pageSize = pageSize;
		this.totalPage = (int) ((this.totalRecord + this.pageSize - 1) / this.pageSize);
		this.start = 1;
		this.end = 10;
		if (this.totalPage <= 10) {
			this.end = this.totalPage;
		} else {
			this.start = this.currentPage - 4;
			this.end = this.currentPage + 5;

			if (this.start < 1) {
				this.start = 1;
				this.end = 10;
			}
			if (this.end > this.totalPage) {
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
		}

	}

	public final int getCurrentPage() {
		return currentPage;
	}

	public final void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public final long getTotalRecord() {
		return totalRecord;
	}

	public final void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public final int getPageSize() {
		return pageSize;
	}

	public final void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public final int getTotalPage() {
		return totalPage;
	}

	public final void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public final List<T> getData() {
		return data;
	}

	public final void setData(List<T> data) {
		this.data = data;
	}

	public final int getStart() {
		return start;
	}

	public final void setStart(int start) {
		this.start = start;
	}

	public final int getEnd() {
		return end;
	}

	public final void setEnd(int end) {
		this.end = end;
	}
}
