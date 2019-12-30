/**
 * @program: kefubbs
 * @description: 主页controller
 * @author: Wu
 * @create: 2019-12-10 13:31
 **/
package com.wu.kefubbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}

