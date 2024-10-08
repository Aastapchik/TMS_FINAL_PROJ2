package myProj.service;

import myProj.dataBase.request.user.UserRequestDB;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import static java.lang.Math.round;
import static myProj.dataBase.request.user.UserRequestDB.findUserByUsername;
import static myProj.dataBase.request.user.UserRequestDB.getGradeUser;

@Service
public class UserService {

    public static double getAverage(int[] ints) {
        double sum = 0.00;
        for (int anInt : ints) sum += anInt;
        return sum / ints.length;
    }

    public static void addScoreUserFromModel(Model model, int id){
        double score = getAverage(getGradeUser(id));
        long scoreInt = round(score);
        model.addAttribute("score", scoreInt);
        model.addAttribute("scoreNoRound", String.format("%.2f", score));
    }

    public static int getID() {
        return findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
    }



}
