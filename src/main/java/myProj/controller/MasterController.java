package myProj.controller;

import myProj.service.MasterControllerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
//@RequestMapping(path = "/profi/master")
public class MasterController {

    MasterControllerService masterControllerService;

    @GetMapping(path = "/profi-master-welcome")
    private String loginMaster(Model model) {
        masterControllerService.loginMaster(model);
        return "masterPage";
    }

    @GetMapping(path = "/profi-master-settings")
    private String showMasterSettings(Model model) {
        masterControllerService.showMasterSettings(model);
        return "masterCardPage";
    }


    @PostMapping(path = "/profi-master-update-card")
    private String updateMaster(@RequestParam(name = "newNameUser") String newName,
                                @RequestParam(name = "newSurnameUser") String newSurname,
                                @RequestParam(name = "newDescriptionUser") String newDescription,
                                @RequestParam(name = "newSpheresActivityUser") String newSpheresActivityUser,
                                Model model) {
        masterControllerService.updateMaster(newName, newSurname, newSpheresActivityUser, newDescription, model);
        return "masterCardPage";
    }

    @GetMapping(path = "/profi-master-show-orders")
    private String showingAvailableOrdersMaster(Model model) {
        masterControllerService.showingAvailableOrdersMaster(model);
        return "availableOrder";
    }

    @PostMapping(path = "/profi-master-add-order")
    private String addOrderMaster(@RequestParam(name = "status") String status,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "name") String name,
                                  Model model) {
        masterControllerService.addOrderMaster(name, status, description, model);
        return "availableOrder";
    }

    @PostMapping(path = "/profi-master-remove-order")
    private String removeOrderMaster(@RequestParam(name = "status") String status,
                                     @RequestParam(name = "description") String description,
                                     @RequestParam(name = "name") String name,
                                     Model model) {
        masterControllerService.removeOrderMaster(name, status, description, model);
        return "masterPage";
    }

    @PostMapping(path = "/profi-master-report-completion")
    private String setApproveOrder(@RequestParam(name = "status") String status,
                                   @RequestParam(name = "description") String description,
                                   @RequestParam(name = "name") String name,
                                   Model model) {
        masterControllerService.setApproveOrder(name, status, description, model);
        return "masterPage";

    }


    @PostMapping(path = "/profi-master-show-review")
    private String showReviewMaster(@RequestParam(name = "idUser") String idUser, Model model) {
        masterControllerService.showReviewMaster(idUser, model);
        return "addReviewMaster";
    }

    @PostMapping(path = "/profi-master-add-review")
    private String addReviewMasterPost(@RequestParam(name = "review") String review,
                                       @RequestParam(name = "rating") int grade,
                                       @RequestParam(name = "idUser") String idUser,
                                       Model model) {
        masterControllerService.addReviewMasterPost(idUser, review, grade, model);
        return "masterPage";
    }

}
