package com.wu.kefubbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@PreAuthorize("hasRole('ROLE_MANAGER')")
//@Secured({"ROLE_MANAGER","ROLE_USER"})
//@RolesAllowed({"ROLE_USER","ROLE_MANAGER"})
public class UserController {

    @RequestMapping("/user/index")
    public String showUserIndex() {
        return "user/index";
    }
}
