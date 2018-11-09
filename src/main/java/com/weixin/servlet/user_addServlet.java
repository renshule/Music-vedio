package com.weixin.servlet;

import com.weixin.bean.User;
import com.weixin.service.serviceimple.user_addServiceImp;
import com.weixin.servce.user_addService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/user_addServlet/*")
public class user_addServlet extends HttpServlet {
    user_addService user_addService = new user_addServiceImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123456);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pathInfo = request.getPathInfo().substring(1);
        if("add".equals(pathInfo)){
            add(request,response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String psd = request.getParameter("psd");
        User user = new User(null,name,psd);
        try {
            boolean b = user_addService.insert(user);
            if(b){
                request.setAttribute("msg","注册成功");
            }else{
                request.setAttribute("msg","注册失败");
            }
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
