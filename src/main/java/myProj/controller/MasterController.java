package myProj.controller;

import myProj.dataBase.request.master.MasterRequestDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static myProj.dataBase.request.master.MasterRequestDB.getMasterOrderFromModel;
import static myProj.dataBase.request.user.UserRequestDB.*;
import static myProj.dataBase.request.user.UserRequestDB.getUserCardFromModel;
import static myProj.service.UserService.addScoreUserFromModel;
import static myProj.service.UserService.getID;


@Controller
//@RequestMapping(path = "/profi/master")
public class MasterController {

    @GetMapping(path = "/profi-master-welcome")
    private String loginMaster(Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        getMasterOrderFromModel(model,id);
        return "masterPage";
    }

    @GetMapping(path = "/profi-master-settings")
    private String showMasterSettings(Model model){

        int id = getID();
        addToModelUserReview(model, id);
        addScoreUserFromModel(model, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
        return "masterCardPage";
    }


    @PostMapping(path ="/profi-master-update-card")
    private String updateMaster(@RequestParam(name = "newNameUser") String newName,
                              @RequestParam(name = "newSurnameUser") String newSurname,
                              @RequestParam(name = "newDescriptionUser") String newDescription,
                              @RequestParam(name = "newSpheresActivityUser") String newSpheresActivityUser,
                              Model model) {
        int id = getID();
        updateUserCard(newName, newSurname, newSpheresActivityUser, newDescription, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
        addScoreUserFromModel(model, id);
        addToModelUserReview(model, id);
        return "masterCardPage";
    }

    @GetMapping(path ="/profi-master-show-orders")
    private String showingAvailableOrdersMaster(Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        MasterRequestDB.getAvailableOrderFromModel(model);
        return "availableOrder";
    }

    @PostMapping(path = "/profi-master-add-order")
    private String addOrderToMaster(@RequestParam(name = "status") String status,
                                    @RequestParam(name = "description") String description,
                                    @RequestParam(name = "name") String name,
                                    Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        MasterRequestDB.getAvailableOrderFromModel(model);
        MasterRequestDB.addOrderToMaster(name, status, description);
        return "availableOrder";
    }

    @PostMapping(path = "/profi-master-remove-order")
    private String removeOrderToMaster(@RequestParam(name = "status") String status,
                                    @RequestParam(name = "description") String description,
                                    @RequestParam(name = "name") String name,
                                    Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        MasterRequestDB.getAvailableOrderFromModel(model);
        MasterRequestDB.addOrderToMaster(name, status, description);
        return "availableOrder";
    }




}
