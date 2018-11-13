package com.weixin.servlet;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/UploadServlet/*")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo().substring(1);
        if ("pic".equals(pathInfo)) {
            pic(request, response);
        } else if ("audio".equals(pathInfo)) {
            audio(request, response);
        }


    }

    private void audio(HttpServletRequest request, HttpServletResponse response) {
        try {
            SmartUpload smart = new SmartUpload();
            smart.initialize(getServletConfig(), request, response);
            smart.setCharset("utf-8");
            smart.upload();
            Files files = smart.getFiles();
            String ext = files.getFile(0).getFileExt();
            String upload_fileName = UUID.randomUUID() + "." + ext;
            files.getFile(0).saveAs("/audio/" + upload_fileName);
            String path = "/audio/" + upload_fileName;
            response.getWriter().print(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //上传：

        private void pic (HttpServletRequest request, HttpServletResponse response){
            try {
                SmartUpload smart = new SmartUpload();
                smart.initialize(getServletConfig(), request, response);
                smart.setCharset("utf-8");
                smart.upload();
                Files files = smart.getFiles();
                String ext = files.getFile(0).getFileExt();
                String upload_fileName = UUID.randomUUID() + "." + ext;
                files.getFile(0).saveAs("/upload/" + upload_fileName);
                String path = "/upload/" + upload_fileName;
                response.getWriter().print(path);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
   
}