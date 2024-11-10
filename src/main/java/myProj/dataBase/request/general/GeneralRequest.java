package myProj.dataBase.request.general;

import myProj.config.SecurityConfig;
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

import static myProj.dataBase.AppCfg.entityManagerFactory;

public class GeneralRequest {

    private static PasswordEncoder passwordEncoder = SecurityConfig.passwordEncoder();
    private static SessionFactory sf = entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();


    public static void addModelAllSphereActivity(Model model) {

        List<String> spheresActivity;
        try (Session session = sf.getCurrentSession()) {

            if (!session.getTransaction().isActive()) session.beginTransaction();
            Query query = session.createQuery("SELECT nameActivity FROM SphereActivity");
            spheresActivity = query.getResultList();
        }
        spheresActivity = spheresActivity.stream().distinct().collect(Collectors.toList());
        model.addAttribute("spheres", spheresActivity);

    }

    public static void saveUser(String login, String password, String name, String surname, String role) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        UserCard userCard = new UserCard(6, "Заполните описание", name, surname);
        user.setUserCard(userCard);
        try (Session session = sf.getCurrentSession()) {
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public static void createUserCardNewUser(String login, String name, String surname) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            User user = UserRequestDB.findUserByUsername(login);
            UserCard userCard = new UserCard(6, "Заполните описание", name, surname);
            userCard.setUser(user);
            session.save(userCard);
            session.getTransaction().commit();
        }
    }


}
