package myProj.controller;

import myProj.dataBase.request.master.MasterRequestDB;
import myProj.dataBase.request.user.UserRequestDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static myProj.dataBase.request.master.MasterRequestDB.addAllMasterFromModel;
import static myProj.dataBase.request.user.UserRequestDB.addAllUserFromModel;

@Controller
public class AdminController {


    @GetMapping(path = "/profi-admin-welcome")
    private String loginAdmin(Model model){
        addAllUserFromModel(model);
        addAllMasterFromModel(model);

        return "adminPanel";
    }





}
