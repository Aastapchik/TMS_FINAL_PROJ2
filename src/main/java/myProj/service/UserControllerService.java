package myProj.service;

import myProj.localMemory.Const;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static myProj.dataBase.request.general.GeneralRequest.addModelAllSphereActivity;
import static myProj.dataBase.request.user.UserRequestDB.*;
import static myProj.service.UserService.addScoreUserFromModel;
import static myProj.service.UserService.getID;

@Service
public class UserControllerService {

    public void loginUser(Model model){
        int id = getID();
        getUsernameFromModel(model, id);
    }

    public void viewingOrdersUser(Model model){
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.STATES_ORDER);
        int id = getID();
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
    }

    public void creatingOrderUser(String orderName, Model model){
        int id = getID();
        addModelAllSphereActivity(model);
        model.addAttribute("nameOrderUser", orderName);
        getUsernameFromModel(model, id);
    }

    public void saveOrderFromUser(String nameOrder, String description, String sphere, Model model){
        int id = getID();
        saveOrderUser(nameOrder, description, sphere, id);
        //saveOrderToAvailable(nameOrder, description, sphere);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.STATES_ORDER);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
    }

    public void deleteOrderFromUser(String name, String description, String status, Model model){
        int id = getID();
        deleteOrderUser(name, status, description);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.STATES_ORDER);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
    }

    public void showSettingPageUser(Model model){
        int id = getID();
        addToModelUserReview(model, id);
        addScoreUserFromModel(model, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
    }

    public void updateUser(String newName, String newSurname, String newSpheresActivityUser, String newDescription, Model model){
        int id = getID();
        updateUserCard(newName, newSurname, newSpheresActivityUser, newDescription, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
        addScoreUserFromModel(model, id);
        addToModelUserReview(model, id);
    }

    public void showReviewUser(String idUser, Model model){
        model.addAttribute("idUser", idUser);
        int id = getID();
        getUsernameFromModel(model, id);
    }

    public void addReviewUserPost(String idUser, String review, int grade, Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        model.addAttribute("cities", Const.CITIES);
        model.addAttribute("states", Const.STATES_ORDER);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        addReviewFromUser(Integer.parseInt(idUser), review, grade);
    }
}
