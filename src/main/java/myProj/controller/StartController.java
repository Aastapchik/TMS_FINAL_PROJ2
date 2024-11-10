package myProj.controller;

import myProj.service.StartServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(path = "/profi")
public class StartController {

    @Autowired
    StartServiceController startServiceController;

    @GetMapping(path = "/profi-welcome")
    private String welcomeGuest(Model model) {
        startServiceController.welcomeGuest(model);
        return "guestPage";
    }

    @GetMapping(path = "/profi-registration")
    private String showRegistrationPageGuest(Model model) {
        startServiceController.showRegistrationPageGuest(model);
        return "registrationForm";
    }

    @GetMapping(path = "/profi-logout")
    private String logout(Model model) {
        startServiceController.logout(model);
        return "guestPage";
    }

    @PostMapping(path = "/profi-save-new-account")
    private String addUser(@RequestParam(name = "login") String login,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "nameUser") String name,
                           @RequestParam(name = "surnameUser") String surname,
                           @RequestParam(name = "passwordRepeat") String passwordRepeat,
                           @RequestParam(name = "role") String role,
                           Model model) {
        if (startServiceController.addUser(login, password, name, surname, passwordRepeat, role, model)) return "guestPage";
        else return "registrationForm";

    }


}
