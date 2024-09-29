package myProj.dataBase.request.master;

import myProj.dataBase.AppCfg;
import myProj.dataBase.request.user.UserRequestDB;
import myProj.entity.User;
import myProj.entity.UserOrder;
import myProj.localMemory.Const;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.util.List;

import static myProj.dataBase.AppCfg.entityManagerFactory;

public class MasterRequestDB {

    private static SessionFactory sf = entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();

    public static void getMasterOrderFromModel(Model model, int id) {
        List<UserOrder> masterOrderList;
        try (Session session = sf.getCurrentSession()) {

            if (!tr.isActive()) session.beginTransaction();
            Query getMasterOrderList = session.createQuery("SELECT masterOrders FROM User where id=:id ");
            getMasterOrderList.setParameter("id", id);
            masterOrderList = getMasterOrderList.getResultList();
            if (tr.isActive()) tr.commit();
        }
        model.addAttribute("masterOrders", masterOrderList);
    }

    public static void getAvailableOrderFromModel(Model model) {
        List<UserOrder> availableOrderList;
        try (Session session = sf.getCurrentSession()) {
            if (!tr.isActive()) session.beginTransaction();
            Query getAvailableOrderList = session.createQuery("SELECT userOrders FROM User");

            availableOrderList = getAvailableOrderList.getResultList();
            if (tr.isActive()) tr.commit();
        }
        for (int i = 0; i < availableOrderList.size(); i++)
            if (!availableOrderList.get(i).getStatus().equals(Const.statesOrder.get(2))) availableOrderList.remove(i);

        model.addAttribute("availableOrders", availableOrderList);
    }

    public static void addOrderToMaster(String nameOrder, String status, String description) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();//  Query query = session.createQuery("FROM UserOrder WHERE nameOrder =: nameOrder AND status =: status AND descriptionOrder =: description");
            Query up = session.createQuery("UPDATE UserOrder SET status =: status, master =: master WHERE nameOrder =: nameOrder AND descriptionOrder =: description ");
            up.setParameter("nameOrder", nameOrder.trim());
            up.setParameter("status", Const.statesOrder.get(1));
            up.setParameter("description", description.trim());
            up.setParameter("master", UserRequestDB.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
            up.executeUpdate();
            session.getTransaction().commit();
        }

    }

    public static void removeOrderToMaster(String nameOrder, String status, String description) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query up = session.createQuery("UPDATE UserOrder SET status =: status, master =: master WHERE nameOrder =: nameOrder AND descriptionOrder =: description ");
            up.setParameter("nameOrder", nameOrder.trim());
            up.setParameter("status", Const.statesOrder.get(1));
            up.setParameter("description", description.trim());
            up.setParameter("master", null);
            up.executeUpdate();
            session.getTransaction().commit();
        }

    }
}
