package com.honpe.page.web;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.support.RequestContext;

import com.github.pagehelper.PageInfo;
import com.honpe.constant.Constant;
import com.honpe.content.service.CategoryService;
import com.honpe.content.service.ContentService;
import com.honpe.page.annotation.CountView;
import com.honpe.po.Content;
import com.honpe.po.ContentCategory;
import com.honpe.po.ContentWithBLOBs;
import com.honpe.po.Seo;
import com.honpe.po.SystemSet;
import com.honpe.pojo.dto.CategoryDto;
import com.honpe.pojo.ext.ContentExt;
import com.honpe.pojo.vo.CaseVo;
import com.honpe.pojo.vo.PageBean;
import com.honpe.system.service.SeoService;
import com.honpe.system.service.SystemService;

@Controller
public class PageController {

	@Autowired
	private ContentService contentService;
	@Autowired
	private SeoService seoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CategoryService categoryService;
	private final int PAGE = 1;
	private final int PAGE_SIZE = 10;
	private final int NEWS_PAGE_SIZE = 5;

	@PostConstruct
	public void loadSystemSettingToCache() {
		ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		List<SystemSet> systemSets = systemService.findSystemSetting();
		systemSets.forEach(systemSet -> servletContext.setAttribute(systemSet.getSetKey(), systemSet.getSetValue()));
	}

	@GetMapping("/")
	public String welcome() {
		return "redirect:index";
	}

	@GetMapping("/tologin")
	public String toLogin(Model model) {
		model.addAttribute("isLogin", true);
		return "forward:index";
	}

	@GetMapping("/toregist")
	public String toRegist(Model model) {
		model.addAttribute("isRegist", true);
		return "forward:index";
	}

	@GetMapping("/toreset")
	public String toForget(Model model) {
		model.addAttribute("isReset", true);
		return "forward:index";
	}

	@GetMapping("/index")
	@CountView(id = 1, pageName = "首页")
	public String index(HttpServletRequest request) {
		addSeoInRequest(request);
		List<ContentExt> swipers = getIndexContent(Constant.CategoryConst.INDEX_SWIPER);
		List<ContentExt> ads = getIndexContent(Constant.CategoryConst.INDEX_AD);
		ContentExt ad = null;
		if (ads != null && !ads.isEmpty()) {
			ad = ads.get(0);
		}
		List<ContentExt> makes = getIndexContent(Constant.CategoryConst.CASE_MAKE);
		List<ContentExt> prints = getIndexContent(Constant.CategoryConst.CASE_3D);
		List<ContentExt> news = getIndexContent(Constant.CategoryConst.NEWS);
		request.setAttribute("swipers", swipers);
		request.setAttribute("ad", ad);
		request.setAttribute("makes", makes);
		request.setAttribute("prints", prints);
		request.setAttribute("news", news);
		return "index";
	}

	@GetMapping("/case")
	@CountView(id = 2, pageName = "案例")
	public String cases(HttpServletRequest request) {
		addSeoInRequest(request);
		List<ContentCategory> categories = categoryService.findChilrenById(Constant.CategoryConst.CASE);
		if (categories != null && categories.size() > 0) {
			ArrayList<CaseVo> cases = new ArrayList<>();
			for (ContentCategory category : categories) {
				List<Content> contents = contentService.findAllByCategoryId(category.getId(), true);
				if (contents != null && contents.size() > 0) {
					CaseVo caseVo = new CaseVo(category, contents);
					cases.add(caseVo);
				}
			}
			request.setAttribute("cases", cases);
		}
		return "case";
	}

	@GetMapping("/detail")
	public String contentDetail(Long id, Model model) {
		ContentWithBLOBs content = contentService.findById(id);
		model.addAttribute("content", content);
		return "detail";
	}

	@GetMapping("/news/detail")
	public String newsDetail(Long id, Model model) {
		ContentWithBLOBs news = contentService.findById(id);
		news.setTimes(news.getTimes() + 1);
		contentService.saveContent(news);
		List<ContentExt> newses = contentService
				.findAllByCategoryId(PAGE, PAGE_SIZE, Constant.CategoryConst.NEWS, true, null).getList().stream()
				.filter(content -> content.getId() != news.getId()).collect(Collectors.toList());
		model.addAttribute("news", news);
		model.addAttribute("newses", newses);
		return "news-detail";
	}

	@GetMapping("/about")
	public String about(@RequestParam(defaultValue = "1") Integer page, Long categoryId, Model model) {
		List<CategoryDto> categories = categoryService.findAllchilrenById(Constant.CategoryConst.ABOUT_US);
		if (categoryId == null) {
			categoryId = Constant.CategoryConst.COMPANY_INSTRODUCE;
		}
		ContentCategory category = categoryService.findById(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("categories", categories);
		if (Constant.CategoryConst.NEWS == categoryId) {
			PageInfo<ContentExt> pageInfo = contentService.findAllByCategoryId(page, NEWS_PAGE_SIZE, categoryId, true,
					null);
			model.addAttribute("pageBean",
					new PageBean<>(page, (int) pageInfo.getTotal(), NEWS_PAGE_SIZE, pageInfo.getList()));
			return "news";
		} else {
			ContentWithBLOBs content = contentService.findOneByCategoryId(categoryId, true);
			model.addAttribute("content", content);
		}
		return "about";
	}

	private void addSeoInRequest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		Seo seo = seoService.findSeoByRouter(uri);
		if (seo != null) {
			request.setAttribute("seo", seo);
		}
	}

	private List<ContentExt> getIndexContent(Long indexCategoryId) {
		List<ContentExt> contents = contentService.findAllByCategoryId(PAGE, PAGE_SIZE, indexCategoryId, true, true)
				.getList();
		return contents;
	}
}
