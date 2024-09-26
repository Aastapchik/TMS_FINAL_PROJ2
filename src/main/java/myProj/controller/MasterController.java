package myProj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping(path = "/profi/master")
public class MasterController {

    @GetMapping(path = "/profi-master-login")
    private String loginMaster(){

        return "loginForm";
    }



}
