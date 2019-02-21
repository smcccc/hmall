package com.honpe.count.service;

import java.util.List;

import com.honpe.po.ViewCount;

public interface CountService {

	void countPageView(ViewCount viewCount);

	List<ViewCount> findAll();

	Long findIndexVisitCount();
}
