package com.xuting.xuwuproject.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author xuting
 * @Date 2019/1/7
 **/
@Controller
public class IndexController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model) {

        Integer.parseInt("1.26");
        return "index";
    }
}
