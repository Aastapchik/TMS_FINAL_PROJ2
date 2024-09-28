package myProj.dataBase.request.general;

import myProj.config.SecurityConfig;
import myProj.dataBase.AppCfg;
import myProj.dataBase.request.user.UserRequestDB;
import myProj.entity.User;
import myProj.entity.UserCard;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralRequest {

    private static PasswordEncoder passwordEncoder = SecurityConfig.passwordEncoder();
    private static SessionFactory sf = AppCfg.entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();


    public static void addModelAllSphereActivity(Model model) {

        List<String> spheresActivity;
        try (Session session = sf.getCurrentSession()) {

            Query query = session.createQuery("SELECT nameActivity FROM SphereActivity");
            spheresActivity = query.getResultList();
        }
        spheresActivity = spheresActivity.stream().distinct().collect(Collectors.toList());
        model.addAttribute("spheres", spheresActivity);

    }

    public static void saveUser(String login, String password, String role) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        UserCard userCard = new UserCard(6, "Заполните описание", "Заполните имя", "Заполните фамилию");
        user.setUserCard(userCard);
        try (Session session = sf.getCurrentSession()) {
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public static void createUserCardNewUser(String login){
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            User user = UserRequestDB.findUserByUsername(login);
            UserCard userCard = new UserCard(6, "Заполните описание", "Заполните имя", "Заполните фамилию");
            userCard.setUser(user);
            session.save(userCard);
            session.getTransaction().commit();
        }
    }



}
