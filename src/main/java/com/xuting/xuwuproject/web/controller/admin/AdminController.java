package com.xuting.xuwuproject.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 后台管理
 * @Author xuting
 * @Date 2019/1/7
 **/
@RequestMapping("admin")
@Controller
public class AdminController {


    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("center")
    public String adminCenterPage() {
        return "admin/center";
    }

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    /**
     * 管理员登录页
     * @return
     */
    @GetMapping("/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    /**
     * 房源列表页
     * @return
     */
    @GetMapping("/house/list")
    public String houseListPage() {
        return "admin/house-list";
    }

}
