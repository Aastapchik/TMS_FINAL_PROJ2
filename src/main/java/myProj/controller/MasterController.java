package myProj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static myProj.dataBase.request.user.UserRequestDB.getUsernameFromModel;
import static myProj.service.UserService.getID;

@Controller
//@RequestMapping(path = "/profi/master")
public class MasterController {

    @GetMapping(path = "/profi-master-login")
    private String loginMaster(Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        return "masterPage";
    }

    @GetMapping(path = "/profi-master-settings")
    private String showMasterSettings(Model model){


        return "masterCardPage";
    }

}
