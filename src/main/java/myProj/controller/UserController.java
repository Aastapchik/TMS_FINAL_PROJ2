package myProj.controller;

import myProj.service.UserControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(path = "/profi/user")
public class UserController {

    @Autowired
    UserControllerService userControllerService;

    @GetMapping(path = "/profi-user-welcome")
    private String loginUser(Model model) {
        userControllerService.loginUser(model);
        return "userPage";
    }

    @GetMapping("/profi-user-myorders")
    protected String viewingOrdersUser(Model model) {
        userControllerService.viewingOrdersUser(model);
        return "myOrdersUser";
    }

    @PostMapping("/profi-user-create-order")
    private String creatingOrderUser(@RequestParam(name = "orderWhichUserWant") String orderName, Model model) {
        userControllerService.creatingOrderUser(orderName, model);
        return "creatingOrder";
    }

    @PostMapping("/profi-user-save-order")
    private String saveOrderFromUser(@RequestParam(name = "nameOrder") String nameOrder,
                                     @RequestParam(name = "sphere") String sphere,
                                     @RequestParam(name = "descriptionOrder") String description,
                                     Model model) {
        userControllerService.saveOrderFromUser(nameOrder, description, sphere, model);
        return "myOrdersUser";
    }

    @PostMapping("/profi-user-delete-order")
    private String deleteOrderFromUser(@RequestParam(name = "status") String status,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "name") String name,
                                       Model model) {
        userControllerService.deleteOrderFromUser(name, description, status, model);
        return "myOrdersUser";
    }

    @GetMapping("/profi-user-settings")
    private String showSettingPageUser(Model model) {
        userControllerService.showSettingPageUser(model);
        return "userCardPage";
    }

    @PostMapping("/profi-user-update-card")
    private String updateUser(@RequestParam(name = "newNameUser") String newName,
                              @RequestParam(name = "newSurnameUser") String newSurname,
                              @RequestParam(name = "newDescriptionUser") String newDescription,
                              @RequestParam(name = "newSpheresActivityUser") String newSpheresActivityUser,
                              Model model) {
        userControllerService.updateUser(newName, newSurname, newDescription, newSpheresActivityUser, model);
        return "userCardPage";
    }


    @PostMapping(path = "/profi-user-show-review")
    private String showReviewUser(@RequestParam(name = "idUser") String idUser, Model model) {
        userControllerService.showReviewUser(idUser, model);
        return "addReviewUser";
    }

    @PostMapping(path = "/profi-user-add-review")
    private String addReviewUserPost(@RequestParam(name = "review") String review,
                                     @RequestParam(name = "rating") int grade,
                                     @RequestParam(name = "idUser") String idUser,
                                     Model model) {
        userControllerService.addReviewUserPost(idUser, review, grade, model);
        return "myOrdersUser";
    }

}
