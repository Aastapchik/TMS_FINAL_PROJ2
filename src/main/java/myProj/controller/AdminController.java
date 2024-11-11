package myProj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static myProj.dataBase.request.master.MasterRequestDB.addAllMasterFromModel;
import static myProj.dataBase.request.user.UserRequestDB.*;

@Controller
public class AdminController {


    @GetMapping(path = "/profi-admin-welcome")
    private String loginAdmin(Model model) {
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-ban-user")
    private String banUser(@RequestParam(name = "id") int id,
                           @RequestParam(name = "reason") String reason,
                           Model model) {


        banUserDB(id, reason);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-ban-master")
    private String banMaster(@RequestParam(name = "id") int id,
                             @RequestParam(name = "reason") String reason,
                             Model model) {

        banUserDB(id, reason);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-unban-user")
    private String unbanUser(@RequestParam(name = "id") int id,
                             Model model) {

        unbanUserDB(id);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-unban-master")
    private String unbanMaster(@RequestParam(name = "id") int id,
                               Model model) {

        unbanUserDB(id);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
        return "adminPanel";
    }


}
