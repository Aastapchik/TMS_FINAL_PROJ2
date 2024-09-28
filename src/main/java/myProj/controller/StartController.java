package myProj.controller;

import myProj.entity.User;
import myProj.localMemory.Const;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static myProj.dataBase.request.general.GeneralRequest.saveUser;
import static myProj.dataBase.request.user.UserRequestDB.findUserByUsername;

@Controller
//@RequestMapping(path = "/profi")
public class StartController {

    @GetMapping(path = "/profi-welcome")
    private String welcome(Model model) {

        model.addAttribute("cities", Const.CITIES);
        return "guestPage";
    }

    @GetMapping(path = "/profi-registration")
    private String showRegistrationPage(Model model) {
        model.addAttribute("cities", Const.CITIES);
        return "registrationForm";
    }

    @GetMapping(path = "/profi-logout")
    private String logout(Model model) {
        model.addAttribute("cities", Const.CITIES);
        return "guestPage";
    }

    @PostMapping(path = "/profi-save-new-account")
    private String addUser(@RequestParam(name = "login") String login,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "passwordRepeat") String passwordRepeat,
                           @RequestParam(name = "role") String role,
                           Model model) {
        User user = findUserByUsername(login);
        if (user != null) {
            model.addAttribute("userNotNULL", true);
            model.addAttribute("login", login);
            model.addAttribute("password", password);
            model.addAttribute("passwordRepeat", passwordRepeat);
            model.addAttribute("role", role);
            return "registrationForm";
        }
        if (!password.equals(passwordRepeat)) {
            model.addAttribute("passwordWrong", true);
            model.addAttribute("login", login);
            model.addAttribute("password", password);
            model.addAttribute("passwordRepeat", passwordRepeat);
            model.addAttribute("role", role);
            return "registrationForm";
        }
        saveUser(login, password, role);

        return "guestPage";
    }


}
