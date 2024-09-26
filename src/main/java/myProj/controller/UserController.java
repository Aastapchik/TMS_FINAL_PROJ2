package myProj.controller;

import myProj.localMemory.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static myProj.dataBase.request.user.UserRequestDB.getUserOrderFromModel;
import static myProj.dataBase.request.user.UserRequestDB.getUsernameFromModel;

@Controller
//@RequestMapping(path = "/profi/user")
public class UserController {


    @GetMapping("/profi-user-myorders")
    protected String viewingOrders(Model model) {
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        getUserOrderFromModel(model, 1);
        getUsernameFromModel(model, 1);
        return "myOrdersUser";
    }

}
