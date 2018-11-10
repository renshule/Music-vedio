package com.weixin.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/ooo")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();

        if(uri.equals("/")||uri.contains("jsp")&&!uri.endsWith("login.jsp")||uri.contains("Servlet")&&!uri.endsWith("LoginServlet")){
            if(request.getSession().getAttribute("user")!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                request.setAttribute("errMsg", "您还没有登录");
                request.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
