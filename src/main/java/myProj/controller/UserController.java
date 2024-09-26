package myProj.controller;

import myProj.localMemory.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
//@RequestMapping(path = "/profi/user")
public class UserController {


    @GetMapping("/profi-user-myorders")
    protected String viewingOrders(Model model) {
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.statesOrder);
        return "myOrdersUser";
    }

}
