package myProj.service;

import jakarta.transaction.Transactional;
import myProj.localMemory.Const;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static myProj.dataBase.request.master.MasterRequestDB.*;
import static myProj.dataBase.request.user.UserRequestDB.*;
import static myProj.dataBase.request.user.UserRequestDB.getUserCardFromModel;
import static myProj.service.UserService.addScoreUserFromModel;
import static myProj.service.UserService.getID;

@Service
@Transactional
public class MasterControllerService {


    public void loginMaster(Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        getMasterOrderFromModel(model, id);
    }

    public void showMasterSettings(Model model){
        int id = getID();
        addToModelUserReview(model, id);
        addScoreUserFromModel(model, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
    }

    public void updateMaster(String newName, String newSurname, String newSpheresActivityUser, String newDescription, Model model){
        int id = getID();
        updateUserCard(newName, newSurname, newSpheresActivityUser, newDescription, id);
        getUserOrderFromModel(model, id);
        getUsernameFromModel(model, id);
        getUserCardFromModel(model, id);
        addScoreUserFromModel(model, id);
        addToModelUserReview(model, id);
    }

    public void showingAvailableOrdersMaster(Model model){
        int id = getID();
        model.addAttribute("states", Const.STATES_ORDER);
        getUsernameFromModel(model, id);
        getAvailableOrderFromModel(model);
    }

    public void addOrderMaster(String name, String status, String description, Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        model.addAttribute("states", Const.STATES_ORDER);
        addOrderToMaster(name, status, description);
        getAvailableOrderFromModel(model);
    }

    public void removeOrderMaster(String name, String status, String description, Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        model.addAttribute("states", Const.STATES_ORDER);
        removeOrderToMaster(name, status, description);
        getMasterOrderFromModel(model, id);
    }

    public void setApproveOrder(String name, String status, String description, Model model){
        int id = getID();
        model.addAttribute("states", Const.STATES_ORDER);
        getUsernameFromModel(model, id);
        approveOrderMaster(name, status, description);
        getMasterOrderFromModel(model, id);
    }

    public void showReviewMaster(String idUser, Model model){
        model.addAttribute("idUser", idUser);
        int id = getID();
        getUsernameFromModel(model, id);
    }

    public void addReviewMasterPost(String idUser, String review, int grade, Model model){
        int id = getID();
        getUsernameFromModel(model, id);
        model.addAttribute("states", Const.STATES_ORDER);
        getMasterOrderFromModel(model, id);
        addReviewFromUser(Integer.parseInt(idUser), review, grade);
    }

}
