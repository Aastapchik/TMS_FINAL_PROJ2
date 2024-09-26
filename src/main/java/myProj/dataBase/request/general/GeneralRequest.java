package myProj.dataBase.request.general;

import myProj.dataBase.AppCfg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

public class GeneralRequest {



    private static SessionFactory sf = AppCfg.entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();


    public static void addModelAllSphereActivity(Model model){

        List<String> spheresActivity;
        try (Session session = sf.getCurrentSession()) {

            Query query = session.createQuery("SELECT nameActivity FROM SphereActivity");
            spheresActivity = query.getResultList();
        }
        model.addAttribute("spheres", spheresActivity);

    }


}
