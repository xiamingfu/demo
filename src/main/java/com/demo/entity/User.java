package com.demo.entity;
import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6249397911566315813L;
    private Integer id;//通过更改这三个成员变量的先后定义位置，即可更改返回的user对象顺序，从而实现网页显示顺序更改
    private String username;
    private String password;
    public void setId(int id)
    {
        this.id=id;
    }
    public void setUsername(String name)
    {
        this.username=name;
    }
    public void setPassword(String keyword)
    {
        this.password=keyword;
    }
     public int getId(){
        return id;
     }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


