package com.honpe.auth.shiro.filter;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.alibaba.druid.support.json.JSONUtils;
import com.honpe.constant.Constant;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.JsonUtils;

/**
 * 验证码过滤器
 * @author Administrator
 *
 */
public class CaptchaValidateFilter extends AccessControlFilter {

	private boolean captchaEbabled = true;// 是否开启验证码支持

	private String captchaParam = "captchaCode";// 前台提交的验证码参数名

	private String failureKeyAttribute = "shiroLoginFailure"; // 验证码验证失败后存储到的属性名
	private static final Logger logger = LoggerFactory.getLogger(CaptchaValidateFilter.class);

	public void setCaptchaEbabled(boolean captchaEbabled) {
		this.captchaEbabled = captchaEbabled;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		if (captchaEbabled == false || !"POST".equalsIgnoreCase(httpServletRequest.getMethod())) {
			return true;
		}
		String submitCaptcha = httpServletRequest.getParameter(captchaParam);
		String captcha = (String) httpServletRequest.getSession().getAttribute("captcha");
		if (submitCaptcha.equals(captcha)) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		Result result = new Result(403, "验证码错误", null);
		String json = JsonUtils.objectToJson(result);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter printWriter = response.getWriter();
		try {
			printWriter.write(json);
			printWriter.flush();
		} catch (Exception e) {
			logger.error("captcha validate fail send fail data,{}:", e);
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
		return false;
	}

}
