package myProj.service;


import jakarta.transaction.Transactional;
import myProj.entity.User;
import myProj.localMemory.Const;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static myProj.dataBase.request.general.GeneralRequest.createUserCardNewUser;
import static myProj.dataBase.request.general.GeneralRequest.saveUser;
import static myProj.dataBase.request.user.UserRequestDB.findUserByUsername;

@Service
@Transactional
public class StartServiceController {

    public void welcomeGuest(Model model) {
        model.addAttribute("cities", Const.CITIES);
    }

    public void showRegistrationPageGuest(Model model){
        model.addAttribute("cities", Const.CITIES);
    }

    public void logout(Model model){
        model.addAttribute("cities", Const.CITIES);
    }

    public boolean addUser(String login, String password, String passwordRepeat, String role, Model model){
        User user = findUserByUsername(login);
        if (user != null) {
            model.addAttribute("userNotNULL", true);
            model.addAttribute("login", login);
            model.addAttribute("password", password);
            model.addAttribute("passwordRepeat", passwordRepeat);
            model.addAttribute("role", role);
            return false;
        }
        if (!password.equals(passwordRepeat)) {
            model.addAttribute("passwordWrong", true);
            model.addAttribute("login", login);
            model.addAttribute("password", password);
            model.addAttribute("passwordRepeat", passwordRepeat);
            model.addAttribute("role", role);
            return false;
        }
        saveUser(login, password, role);
        createUserCardNewUser(login);
        return true;

    }
}
