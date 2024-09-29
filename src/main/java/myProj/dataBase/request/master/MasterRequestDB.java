package myProj.dataBase.request.master;

import myProj.dataBase.AppCfg;
import myProj.entity.UserOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.ui.Model;

import java.util.List;

public class MasterRequestDB {

    private static SessionFactory sf = AppCfg.entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();

    public static void getMasterOrderFromModel(Model model, int id) {
        List<UserOrder> masterOrderList;
        try (Session session = sf.getCurrentSession()) {

            //session.beginTransaction();
            Query getMasterOrderList = session.createQuery("SELECT masterOrders FROM User where id=:id ");
            getMasterOrderList.setParameter("id", id);
            masterOrderList = getMasterOrderList.getResultList();
            session.getTransaction().commit();
        }
        model.addAttribute("masterOrders", masterOrderList);
    }

}
