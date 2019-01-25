package com.honpe.pojo.vo;

import java.util.List;

public class TableResult<T> {
	
	private long total;
	private List<T> rows;

	public TableResult(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public final long getTotal() {
		return total;
	}

	public final void setTotal(long total) {
		this.total = total;
	}

	public final List<T> getRows() {
		return rows;
	}

	public final void setRows(List<T> rows) {
		this.rows = rows;
	}
}
