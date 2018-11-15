package com.weixin.servlet;

import com.weixin.bean.Sing;
import com.weixin.bean.User;
import com.weixin.dao.UserDaoImple.LoginServiceImpl;
import com.weixin.service.LoginService;
import com.weixin.service.UserService;
import com.weixin.service.serviceimple.UserServceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    UserService userService = new UserServceImple();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String passsword = request.getParameter("password");
        request.setAttribute("name", name);


        try {
            User user = loginService.login(name, passsword);
            if(user==null){
                //登录失败:
                //打回登录页:
                request.setAttribute("errMsg","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else if(user.getU_name().equals("root")){
                request.getSession().setAttribute("user",user);
                response.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
            }else{
                //登录成功：
                //跳转到genres.jsp首页：
                /*request.getSession().setAttribute("user",user);
                response.sendRedirect(getServletContext().getContextPath()+"/genres.jsp");*/
                List<Sing> singList=userService.singListAll();
                System.out.println(singList);
                request.setAttribute("singList",singList);
                //中间页面内容
                List<Sing> singList1=userService.singListAll1();
                System.out.println(singList1);
                request.setAttribute("singList1",singList1);
                /*//右边页面内容
                List<Ad> adList=userService.adListAll();
                System.out.println(adList);
                request.setAttribute("adList",adList);*/
                request.setAttribute("name",name);
                request.getRequestDispatcher("/listen1.jsp").forward(request,response);


               /* request.getRequestDispatcher("/genres.jsp").forward(request,response);*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

