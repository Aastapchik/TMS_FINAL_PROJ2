package myProj.controller;

import myProj.dataBase.request.user.UserRequestDB;
import myProj.localMemory.Const;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static myProj.dataBase.request.general.GeneralRequest.addModelAllSphereActivity;
import static myProj.dataBase.request.user.UserRequestDB.*;
import static myProj.service.UserService.addScoreUserFromModel;
import static myProj.service.UserService.getID;

@Controller
//@RequestMapping(path = "/profi/user")
public class UserController {


    @GetMapping(path = "/profi-user-welcome")
    private String pageAfterAuth(Model model) {
        int id = getID();
        getUsernameFromModel(model, id);
        return "userPage";
    }

    @GetMapping("/profi-user-myorders")
    protected String viewingOrders(Model model) {
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        int id = getID();
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        return "myOrdersUser";
    }

    @PostMapping("/profi-user-create-order")
    private String creatingOrder(@RequestParam(name = "orderWhichUserWant") String orderName, Model model) {
        int id = getID();
        addModelAllSphereActivity(model);
        model.addAttribute("nameOrderUser", orderName);
        getUsernameFromModel(model, id);
        return "creatingOrder";
    }

    @PostMapping("/profi-user-save-order")
    private String saveOrder(@RequestParam(name = "nameOrder") String nameOrder,
                             @RequestParam(name = "sphere") String sphere,
                             @RequestParam(name = "descriptionOrder") String description,
                             Model model) {
        int id = getID();
        saveOrderUser(nameOrder, description, sphere, id);
        saveOrderToAvailable(nameOrder, description, sphere);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);

        return "myOrdersUser";
    }

    @PostMapping("/profi-user-delete-order")
    private String deleteOrder(@RequestParam(name = "status") String status,
                               @RequestParam(name = "description") String description,
                               @RequestParam(name = "name") String name,
                               Model model) {
        int id = getID();
        deleteOrderUser(name, status, description);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);

        return "myOrdersUser";
    }

    @GetMapping("/profi-user-settings")
    private String showSettingPage(Model model) {
        int id = getID();
        addToModelUserReview(model, id);
        addScoreUserFromModel(model, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
        return "userCardPage";
    }

    @PostMapping("/profi-user-update-card")
    private String updateUser(@RequestParam(name = "newNameUser") String newName,
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
        return "userCardPage";
    }

}
