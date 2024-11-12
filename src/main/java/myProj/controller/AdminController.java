package myProj.controller;

import myProj.service.AdminControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static myProj.dataBase.request.master.MasterRequestDB.addAllMasterFromModel;
import static myProj.dataBase.request.user.UserRequestDB.*;

@Controller
public class AdminController {

    @Autowired
    AdminControllerService adminControllerService;


    @GetMapping(path = "/profi-admin-welcome")
    private String loginAdmin(Model model) {
        adminControllerService.loginAdmin(model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-ban-user")
    private String banUser(@RequestParam(name = "id") int id,
                           @RequestParam(name = "reason") String reason,
                           Model model) {

      adminControllerService.banUser(id, reason, model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-ban-master")
    private String banMaster(@RequestParam(name = "id") int id,
                             @RequestParam(name = "reason") String reason,
                             Model model) {

        adminControllerService.banMaster(id, reason, model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-unban-user")
    private String unbanUser(@RequestParam(name = "id") int id,
                             Model model) {

        adminControllerService.unbanUser(id, model);
        return "adminPanel";
    }

    @PostMapping(path = "/profi-unban-master")
    private String unbanMaster(@RequestParam(name = "id") int id,
                               Model model) {

       adminControllerService.unbanMaster(id, model);
        return "adminPanel";
    }


}
