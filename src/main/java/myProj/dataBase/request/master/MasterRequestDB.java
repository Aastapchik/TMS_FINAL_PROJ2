package myProj.dataBase.request.master;

import myProj.dataBase.request.user.UserRequestDB;
import myProj.entity.UserOrder;
import myProj.localMemory.Const;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import java.util.ArrayList;
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
        List<UserOrder> actualOrderList = new ArrayList<>();
        for (UserOrder userOrder : availableOrderList)
            if (userOrder.getStatus().equals(Const.STATES_ORDER.get(2))) actualOrderList.add(userOrder);

        model.addAttribute("availableOrders", actualOrderList);
    }

    public static void addOrderToMaster(String nameOrder, String status, String description) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("FROM UserOrder WHERE nameOrder =: nameOrder AND status =: status AND descriptionOrder =: description");
            query.setParameter("nameOrder", nameOrder);
            query.setParameter("status", Const.STATES_ORDER.get(2));
            query.setParameter("description", description);
            UserOrder userOrder = (UserOrder) query.getResultList().get(0);

            userOrder.setMaster(UserRequestDB.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
            userOrder.setStatus(Const.STATES_ORDER.get(1));
            session.update(userOrder);
            session.getTransaction().commit();
        }

    }

    public static void removeOrderToMaster(String nameOrder, String status, String description) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query up = session.createQuery("UPDATE UserOrder SET status =: status, master =: master WHERE nameOrder =: nameOrder AND descriptionOrder =: description ");
            up.setParameter("nameOrder", nameOrder);
            up.setParameter("status", Const.STATES_ORDER.get(2));
            up.setParameter("description", description);
            up.setParameter("master", null);
            up.executeUpdate();
            session.getTransaction().commit();
        }
    }


    public static void approveOrderMaster(String nameOrder, String status, String description){
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query up = session.createQuery("UPDATE UserOrder SET status =: status WHERE nameOrder =: nameOrder AND descriptionOrder =: description");
            up.setParameter("nameOrder", nameOrder);
            up.setParameter("status", Const.STATES_ORDER.get(3));
            up.setParameter("description", description);
            up.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
