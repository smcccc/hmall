package com.honpe.system.service;

import java.util.List;

import com.honpe.po.Seo;

public interface SeoService {

	List<Seo> findAllByPageName(String pageName);

	void addSeo(Seo seo);

	Seo findSeoById(Long id);

	void saveSeo(Seo seo);
	
	void dropSeo(Long id);
	
	Seo findSeoByRouter(String router);
}
