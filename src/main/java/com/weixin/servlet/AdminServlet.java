package com.weixin.servlet;

import com.google.gson.Gson;
import com.weixin.bean.Classify;
import com.weixin.bean.Singer;
import com.weixin.servce.AdminServce;
import com.weixin.servce.servceimple.AdminServceimple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminServlet/*")
public class AdminServlet extends HttpServlet {
    AdminServce as=new AdminServceimple();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset-utf-8");
        String pathInfo = request.getPathInfo().substring(1);
        System.out.println("________________________________________");
        if("classify".equals(pathInfo)){
            classify(request,response);
        }else if("Singer".equals(pathInfo)){
            singer(request,response);
        }else if("User".equals(pathInfo)){
            User(request,response);
        }
    }

    /**
     * 用户列表展示
     * @param request
     * @param response
     */
    private void User(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("+++++++++++++++++++++++++++++++++");
            List<Singer> SingerList=as.SingerListAll();
            System.out.println(SingerList);
            Gson gson = new Gson();
            System.out.println(gson);
            System.out.println("****************************");
            String s = gson.toJson(SingerList);
            response.getWriter().print(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 歌手列表展示
     * @param request
     * @param response
     */
    private void singer(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("+++++++++++++++++++++++++++++++++");
            List<Singer> SingerList=as.SingerListAll();
            System.out.println(SingerList);
            Gson gson = new Gson();
            System.out.println(gson);
            System.out.println("****************************");
            String s = gson.toJson(SingerList);
            response.getWriter().print(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 分类列表展示
     * @param request
     * @param response
     */
    private void classify(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("+++++++++++++++++++++++++++++++++");
            List<Classify> classifyList=as.ClassifyListAll();
            System.out.println(classifyList);
            Gson gson = new Gson();
            System.out.println(gson);
            System.out.println("****************************");
            String s = gson.toJson(classifyList);
            response.getWriter().print(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
