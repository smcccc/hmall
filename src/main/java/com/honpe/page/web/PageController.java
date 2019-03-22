package com.honpe.page.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
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
import com.honpe.pojo.vo.Result;
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
	private final int NEWS_PAGE_SIZE = 5;
	private final int CASE_PAGE_SIZE = 9;

	@PostConstruct
	public void loadSystemSettingToCache() {
		ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		List<SystemSet> systemSets = systemService.findSystemSetting();
		systemSets.forEach(systemSet -> servletContext.setAttribute(systemSet.getSetKey(), systemSet.getSetValue()));
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

	private void addSeoInRequest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		Seo seo = seoService.findSeoByRouter(uri);
		if (seo != null) {
			request.setAttribute("seo", seo);
		}
	}

	@GetMapping("/")
	public String welcome() {
		return "forward:index";
	}

	@GetMapping("/index")
	public String index(HttpServletRequest request) {
		addSeoInRequest(request);
		List<Content> swipers = contentService.findAllByCategoryId(Constant.CategoryConst.INDEX_SWIPER, true, true);
		List<Content> company = contentService.findAllByCategoryId(Constant.CategoryConst.INDEX_US, true, true);
		List<CategoryDto> categories = categoryService.findAllchilrenById(Constant.CategoryConst.CASE);
		if (company != null && company.size() > 0) {
			ContentWithBLOBs content = contentService.findById(company.get(0).getId());
			request.setAttribute("company", content);
		}
		if (categories != null && categories.size() > 0) {
			List<ContentCategory> children = categories.get(0).getCategories();
			if (children != null && children.size() > 0) {
				Long categoryId = children.get(0).getId();
				PageInfo<ContentExt> pageInfo = contentService.findAllByCategoryId(1, CASE_PAGE_SIZE, categoryId, true,
						true);
				request.setAttribute("categoryId", categoryId);
				request.setAttribute("totalPage", pageInfo.getPages());
				request.setAttribute("cases", pageInfo.getList());
			}
		}
		request.setAttribute("swipers", swipers);
		request.setAttribute("categories", categories);
		return "index";
	}

	@GetMapping("/case")
	@CountView(id = 2, pageName = "案例")
	public String cases(Long id, HttpServletRequest request) {
		addSeoInRequest(request);
		List<ContentCategory> bigCategories = categoryService.findChildren(Constant.CategoryConst.CASE, true);
		if (id != null)
			request.setAttribute("currentId", id);
		if (bigCategories != null && bigCategories.size() > 0) {
			ArrayList<CaseVo> cases = new ArrayList<>();
			for (ContentCategory bigCategory : bigCategories) {
				List<ContentCategory> categories = categoryService.findChildren(bigCategory.getId(), false);
				if (categories != null && categories.size() > 0) {
					for (ContentCategory category : categories) {
						List<Content> contents = contentService.findAllByCategoryId(category.getId(), true, null);
						CaseVo caseVo = new CaseVo(category, contents);
						cases.add(caseVo);
					}
				}
			}
			request.setAttribute("cases", cases);
		}
		return "case";
	}

	@GetMapping("/case/list")
	public @ResponseBody Result caseList(@RequestParam(defaultValue = "1") Integer page, Long categoryId) {
		PageInfo<ContentExt> pageInfo = contentService.findAllByCategoryId(page, CASE_PAGE_SIZE, categoryId, true,
				true);
		return new Result(200, null, pageInfo);
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
				.findAllByCategoryId(1, NEWS_PAGE_SIZE, Constant.CategoryConst.NEWS, true, null).getList().stream()
				.filter(content -> content.getId() != news.getId()).collect(Collectors.toList());
		model.addAttribute("news", news);
		model.addAttribute("newses", newses);
		return "news-detail";
	}

	@GetMapping("/about")
	public String about(@RequestParam(defaultValue = "1") Integer page, Long categoryId, Model model) {
		List<CategoryDto> categories = categoryService.findAllchilrenById(Constant.CategoryConst.ABOUT_US);
		if (categoryId == null)
			categoryId = Constant.CategoryConst.COMPANY_INTRODUCE;
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
}
