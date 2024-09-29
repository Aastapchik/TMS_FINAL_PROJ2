package myProj.dataBase.request.master;

import myProj.dataBase.AppCfg;
import myProj.entity.UserOrder;
import myProj.localMemory.Const;
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

            if(!tr.isActive()) session.beginTransaction();
            Query getMasterOrderList = session.createQuery("SELECT masterOrders FROM User where id=:id ");
            getMasterOrderList.setParameter("id", id);
            masterOrderList = getMasterOrderList.getResultList();
            if(tr.isActive()) tr.commit();
            //session.close();
            //session.getTransaction().commit();
        }
        model.addAttribute("masterOrders", masterOrderList);
    }

    public static void getAvailableOrderFromModel(Model model) {
        List<UserOrder> availableOrderList;
        try (Session session = sf.getCurrentSession()) {
            if(!tr.isActive()) session.beginTransaction();
            Query getAvailableOrderList = session.createQuery("SELECT userOrders FROM User");

            availableOrderList = getAvailableOrderList.getResultList();
            if(tr.isActive()) tr.commit();
        }
        for (int i = 0; i < availableOrderList.size(); i++)
            if (!availableOrderList.get(i).getStatus().equals(Const.statesOrder.get(2))) availableOrderList.remove(i);

        model.addAttribute("availableOrders", availableOrderList);
    }

}
