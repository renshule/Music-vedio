package com.weixin.servlet;

import com.google.gson.Gson;
import com.weixin.bean.Classify;
import com.weixin.bean.Sing;
import com.weixin.bean.Singer;
import com.weixin.servce.AdminServce;
import com.weixin.servce.servceimple.AdminServceimple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
        } else if("selectAllSing".equals(pathInfo)){
            selectAllSing(request,response);
        }else if("removeById".equals(pathInfo)){
            removeById(request,response);
        }else if("removeAllSing".equals(pathInfo)){
            removeAllSing(request,response);
        }else if("addSinger".equals(pathInfo)){
            try {
                addSinger(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if ("addSing".equals(pathInfo)){
            try {
                addSing(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 歌曲添加
     * @param request
     * @param response
     */
    private void addSing(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String name = request.getParameter("name");
        String pic = request.getParameter("pic");
        String singerName = request.getParameter("singerName");
        Integer singerId=as.selectSingerByName(singerName);
        int gender =Integer.valueOf(request.getParameter("gender"));
        
        Sing sing=new Sing(null,name,pic,null,gender,null,null);
        try {
            boolean b = as.insertSing(sing);
            System.out.println(b);
            if (b) {
                System.out.println("1");
                request.setAttribute("msg", "添加成功");

            } else {
                System.out.println("0");
                request.setAttribute("msg", "添加失败");
            }
            request.getRequestDispatcher("/music/singAdd.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 歌手添加
     * @param request
     * @param response
     */
    private void addSinger(HttpServletRequest request, HttpServletResponse response)throws SQLException {
        String name = request.getParameter("name");
        String introduce = request.getParameter("introduce");
        System.out.println("aiaiaiiaiiaiiaiaiiiia");
        Singer singer=new Singer(null,name,introduce);
        try {
            boolean b = as.insertSinger(singer);
            System.out.println(b);
            if (b) {

                request.setAttribute("msg", "添加成功");

            } else {

                request.setAttribute("msg", "添加失败");
            }
            request.getRequestDispatcher("/music/singerAdd.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除所选歌曲
     * @param request
     * @param response
     */
    private void removeAllSing(HttpServletRequest request, HttpServletResponse response) {
        //拿参数ids
        String ids = request.getParameter("ids");
        String[] idsArr = ids.split(",");
        try {
            boolean bo = as.removeAllSings(idsArr);
            if (bo) {
                response.getWriter().print("1");
            } else {
                response.getWriter().print("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除某个歌曲
     * @param request
     * @param response
     */
    private void removeById(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("=======================");
        int id=Integer.valueOf(request.getParameter("sing_id"));
        System.out.println(id);
        try {
            boolean bo=as.deleteById(id);
            //            //判断是否删除成功
            if(bo){
                //删除成功回复1
                response.getWriter().print("1");
                System.out.println(bo);

            }else{
                //删除失败回复空字符串
                response.getWriter().print("");
                System.out.println(bo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 歌曲列表展示
     * @param request
     * @param response
     */
    private void selectAllSing(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("+++++++++++++++++++++++++++++++++");
            List<Sing> SingList=as.SingListAll();
            System.out.println(SingList);
            Gson gson = new Gson();
            System.out.println(gson);
            System.out.println("****************************");
            String s = gson.toJson(SingList);
            response.getWriter().print(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        /*else if("User".equals(pathInfo)){
            User(request,response);
        }
    }


    /**
     * 用户列表展示
     * @param request
     * @param response
     */
 /*   private void User(HttpServletRequest request, HttpServletResponse response) {
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
    }*/

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
