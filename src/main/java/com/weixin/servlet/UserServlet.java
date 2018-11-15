package com.weixin.servlet;

import com.google.gson.Gson;
import com.weixin.bean.User;
import com.weixin.service.UserService;
import com.weixin.service.serviceimple.UserServceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/UserServlet/*")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServceImple();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pathInfo = request.getPathInfo().substring(1);
        if("listAll".equals(pathInfo)){
            try {
                listAll(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 页面展示
     * @param request
     * @param response
     */
    /*private void selectLeftAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("+++++++++++++++++++++++++++++++++");
        try {
            //左侧页面内容
            List<Sing> singList=userService.singListAll();
            System.out.println(singList);
            request.setAttribute("singList",singList);
            //中间页面内容
            List<Sing> singList1=userService.singListAll1();
            System.out.println(singList1);
            request.setAttribute("singList1",singList1);
            //右边页面内容
            List<Ad> adList=userService.adListAll();
            System.out.println(adList);
            request.setAttribute("adList",adList);
            request.getRequestDispatcher("/listen1.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * 用户列表展示
     * @param request
     * @param response
     * @throws Exception
     */
    private void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<User> userList = userService.selectAll();
        Gson gson = new Gson();
        String s = gson.toJson(userList);
        response.getWriter().print(s);
        System.out.println(s);
    }


}
