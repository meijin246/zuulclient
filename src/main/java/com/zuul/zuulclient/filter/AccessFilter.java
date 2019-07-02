package com.zuul.zuulclient.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter extends ZuulFilter{
    @Override
    public String filterType(){
        return "pre";
    }

    @Override
    public int filterOrder(){
        return 0;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getParameter("accessToken");
        if(request.getRequestURI()!=null && request.getRequestURI().startsWith("/testzuul/") && StringUtils.isEmpty(accessToken)){
            ctx.setResponseStatusCode(403);
            ctx.setResponseBody("accessToken 不能为空  " + request.getContextPath());
            ctx.sendZuulResponse();
        }
        return null;
    }
}
