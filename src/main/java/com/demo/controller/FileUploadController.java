package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.demo.service.FilePathService;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController//之前为ControLler
@RequestMapping("/user")
public class FileUploadController {

    @Autowired
    private FilePathService filePathService;
    // 传入的参数file是我们指定的文件
    @RequestMapping(value="/upload" )
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        return filePathService.Upload(file);
    }


    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "01.mp4" + "";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "G:/video/";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// // 下载后的文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


}
