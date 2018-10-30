package com.demo.controller;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public User save() {
        User user = new User();
        int id = new Random().nextInt(10000);
        user.setId(id);
        user.setUsername("张三" + id);
        user.setPassword("zhangsan" + id);

        int result = this.userService.insert(user);//调用这个向数据库写入
        System.out.println(result);
        return user;//返回对象，才是真正springboot实现的在网站页面上出现的内容
    }

    @RequestMapping("/getById")
    @ResponseBody
    public User getById(Integer id) {
        User user = this.userService.getById(5930);
        System.out.println(user.getUsername());
        return user;
    }

    @RequestMapping("/update")
    public void update() {
        User user = new User();
        user.setId(1);
        user.setPassword("test123");
        this.userService.update(user);
    }

    @RequestMapping("/deleteById")
    public void deleteById(Integer id) {
        int result = this.userService.deleteById(id);
        System.out.println(result);
    }
}

