package myProj.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static myProj.dataBase.request.master.MasterRequestDB.addAllMasterFromModel;
import static myProj.dataBase.request.user.UserRequestDB.*;

@Service
@Transactional
public class AdminControllerService {

    public void loginAdmin(Model model) {
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
    }

    public void banUser(int id, String reason, Model model) {
        banUserDB(id, reason);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
    }

    public void banMaster(int id, String reason, Model model) {
        banUserDB(id, reason);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
    }

    public void unbanUser(int id, Model model) {
        unbanUserDB(id);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
    }

    public void unbanMaster(int id, Model model) {
        unbanUserDB(id);
        addAllUserFromModel(model);
        addAllMasterFromModel(model);
    }

}
