package com.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
@Controller
/*1.@restcontroller中，返回的应该是一个对象，即return一个user对象，这时，
在没有页面的情况下，也能看到返回的是一个user对象对应的json字符串，
而前端的作用是利用返回的json进行解析渲染页面，java后端的代码比较自由。
  2.在@controller注解中，返回的是字符串，或者是字符串匹配的模板名称，
即直接渲染视图，与html页面配合使用的，在这种情况下，前后端的配合要求比较高，
java后端的代码要结合html的情况进行渲染,使用model对象（或者modelandview）
的数据将填充user视图中的相关属性，然后展示到浏览器，这个过程也可以称为渲染；
*/
@RequestMapping("/user")
public class UserController2{
        @RequestMapping(value = "/index")
        public String hello(Model model) {
            //model.addAttribute("name", "Dear");
            return "hello";//上面两行的hello和返回的"hello"，就是对应的thymeleaf的html页面名字，
            //在这个工程里面就是  resources/templates/hello.html，这样就可以实现映射
        }
    //跳转到上传文件的页面
    @RequestMapping(value="/uploading")//这个网址名字不能和下面的upload方法一样，应该说和另一个 映射重复了
    public String uploading(Model model) {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploading";
    }
    //跳转到下载文件的页面
    @RequestMapping(value="/downloading")//这个网址名字不能和下面的upload方法一样，应该说和另一个 映射重复了
    public String downloading(Model model) {
        //跳转到 templates 目录下的 uploadimg.html
        return "downloading";
    }

    }

