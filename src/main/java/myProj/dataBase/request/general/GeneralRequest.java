package myProj.dataBase.request.general;

import myProj.config.SecurityConfig;
import myProj.dataBase.AppCfg;
import myProj.entity.User;
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
        try (Session session = sf.getCurrentSession()) {

            session.save(user);
            session.getTransaction().commit();
        }
    }


}
