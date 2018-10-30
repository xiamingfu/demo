package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity//加入这个注解，就会进行持久化了
@Table(name = "t_uers")//声明在数据库中自动生成的表名为t_users
public class FilePath {
   // @Column(name = "Id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        this.Path = path;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer id;

    public String Path;
}
