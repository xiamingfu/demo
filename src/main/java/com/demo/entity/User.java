package com.demo.entity;
import java.io.Serializable;
public class User implements Serializable {

    private static final long serialVersionUID = -6249397911566315813L;

    private Integer id;

    private String username;

    private String password;
    public void setId(int ide)
    {
        id=ide;
    }
    public void setUsername(String name)
    {
        username=name;
    }
    public void setPassword(String keyword)
    {
        password=keyword;
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
    ;
                ;
}

