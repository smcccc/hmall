package com.honpe.auth.shiro.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import cn.dsna.util.images.ValidateCode;

public class CaptchaFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(CaptchaFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ValidateCode validateCode = new ValidateCode(120, 30, 4, 9);
		String captcha = validateCode.getCode().toLowerCase();
		request.getSession().setAttribute("captcha", captcha);
		ServletOutputStream out = response.getOutputStream();
		try {
			validateCode.write(out);
			out.flush();
		} catch (Exception e) {
			logger.error("captcha send fail");
			if (out != null) {
				out.close();
			}
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
