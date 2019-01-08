package com.xuting.xuwuproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author xuting
 * @Date 2019/1/4
 **/
@Data
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    /**
    * 0:正常，1:封禁
    **/
    private int status;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 上次登录时间
     **/
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
    * 头像
    **/
    private String avatar;

}
