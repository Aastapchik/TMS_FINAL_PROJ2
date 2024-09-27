package myProj.controller;

import myProj.dataBase.request.user.UserRequestDB;
import myProj.localMemory.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static myProj.dataBase.request.general.GeneralRequest.addModelAllSphereActivity;
import static myProj.dataBase.request.user.UserRequestDB.getUserOrderFromModel;
import static myProj.dataBase.request.user.UserRequestDB.getUsernameFromModel;

@Controller
//@RequestMapping(path = "/profi/user")
public class UserController {
    @GetMapping(path = "/profi-user-welcome")
    private String pageAfterAuth(Model model) {
        getUsernameFromModel(model, 1);
        return "startPagePROFI";
    }

    @GetMapping("/profi-user-myorders")
    protected String viewingOrders(Model model) {
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        getUserOrderFromModel(model, 1);
        getUsernameFromModel(model, 1);
        return "myOrdersUser";
    }

    @PostMapping("/profi-user-create-order")
    private String creatingOrder(@RequestParam(name = "orderWhichUserWant") String orderName, Model model) {
        addModelAllSphereActivity(model);
        model.addAttribute("nameOrderUser", orderName);
        getUsernameFromModel(model, 1);
        return "creatingOrder";
    }

    @PostMapping("/profi-user-save-order")
    private String saveOrder(@RequestParam(name = "nameOrder") String nameOrder,
                             @RequestParam(name = "sphere") String sphere,
                             @RequestParam(name = "descriptionOrder") String description,
                             Model model) {

        UserRequestDB.saveOrderUser(nameOrder, description, sphere);
        UserRequestDB.saveOrderToAvailable(nameOrder, description, sphere);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        getUserOrderFromModel(model, 1);
        getUsernameFromModel(model, 1);

        return "myOrdersUser";
    }

    @PostMapping("/profi-user-delete-order")
    private String deleteOrder(@RequestParam(name = "status") String status,
                               @RequestParam(name = "description") String description,
                               @RequestParam(name = "name") String name,
                               Model model) {
        System.out.println(status + " " + description + " " + name);
        UserRequestDB.deleteOrderUser(name, status, description);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        getUserOrderFromModel(model, 1);
        getUsernameFromModel(model, 1);

        return "myOrdersUser";
    }

}
