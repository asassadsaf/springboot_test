package com.fkp.springboot_deploy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/findAll")
    public String findAll(){
        return "success!";
    }
}
