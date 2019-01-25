package com.honpe.system.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.mapper.SeoMapper;
import com.honpe.po.Seo;
import com.honpe.po.SeoExample;
import com.honpe.system.service.SeoService;

@Service
@Transactional
public class SeoServiceImpl implements SeoService {

	@Autowired
	private SeoMapper seoMapper;

	@Override
	public List<Seo> findAllByPageName(String pageName) {
		SeoExample seoExample = new SeoExample();
		if (StringUtils.isNoneBlank(pageName)) {
			seoExample.createCriteria().andPageNameLike('%' + pageName + '%');
		}
		seoExample.setOrderByClause("id ASC");
		List<Seo> seos = seoMapper.selectByExample(seoExample);
		return seos;
	}

	@Override
	public void addSeo(Seo seo) {
		seo.setCreateTime(new Date());
		seoMapper.insertSelective(seo);
	}

	@Override
	public Seo findSeoById(Long id) {
		return seoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveSeo(Seo seo) {
		seo.setUpdateTime(new Date());
		seoMapper.updateByPrimaryKeySelective(seo);
	}

	@Override
	public void dropSeo(Long id) {
		seoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Seo findSeoByRouter(String router) {
		SeoExample seoExample = new SeoExample();
		seoExample.createCriteria().andRouterEqualTo(router);
		List<Seo> seos = seoMapper.selectByExample(seoExample);
		Seo seo = null;
		if (seos != null && seos.size() > 0) {
			seo = seos.get(0);
		}
		return seo;
	}
}
