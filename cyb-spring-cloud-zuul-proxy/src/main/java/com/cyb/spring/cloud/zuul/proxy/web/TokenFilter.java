package com.cyb.spring.cloud.zuul.proxy.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TokenFilter extends ZuulFilter {

	/**
	 * 日志接口
	 */
	private static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.debug("%s >>> %s", request.getMethod(), request.getRequestURI());

		Object token = request.getParameter("token");
		if (token == null) {
			logger.warn("Token is empty.");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);

			try {
				context.getResponse().getWriter().write("Token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			logger.debug("ok");
		}

		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
