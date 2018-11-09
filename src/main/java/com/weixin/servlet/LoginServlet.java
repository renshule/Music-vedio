package com.weixin.servlet;

import com.weixin.bean.User;
import com.weixin.dao.UserDaoImple.LoginServiceImpl;
import com.weixin.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passsword = request.getParameter("password");

        try {
            User user = loginService.login(name, passsword);
            if(user==null){
                //登录失败:
                //打回登录页:
                request.setAttribute("errMsg","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                //登录成功：
                //跳转到index首页：
                request.getSession().setAttribute("user",user);
                response.sendRedirect(getServletContext().getContextPath()+"/genres.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

