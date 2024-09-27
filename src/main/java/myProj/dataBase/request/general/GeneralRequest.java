package myProj.dataBase.request.general;

import myProj.dataBase.AppCfg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GeneralRequest {



    private static SessionFactory sf = AppCfg.entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();


    public static void addModelAllSphereActivity(Model model){

        List<String> spheresActivity;
        try (Session session = sf.getCurrentSession()) {

            Query query = session.createQuery("SELECT nameActivity FROM SphereActivity");
            spheresActivity = query.getResultList();
        }
        spheresActivity = spheresActivity.stream().distinct().collect(Collectors.toList());
        model.addAttribute("spheres", spheresActivity);

    }


}
