package myProj.dataBase.request.user;

import myProj.dataBase.AppCfg;
import myProj.entity.*;
import myProj.localMemory.Const;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

@Component
public class UserRequestDB {

    private static SessionFactory sf = AppCfg.entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();


    public static String getUser() throws SQLException {

        String login;
        try (Session session = sf.getCurrentSession()) {

            Query query = session.createQuery("SELECT login FROM User where id = 1");
            login = (String) query.getResultList().get(0);

        }
        return login;

    }

    public static void getUserOrderFromModel(Model model, int id) {
        List<UserOrder> userOrderList;
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();
            Query getUserOrderList = session.createQuery("SELECT userOrders FROM User where id=:id ");
            getUserOrderList.setParameter("id", id);
            userOrderList = getUserOrderList.getResultList();

        }
        model.addAttribute("orders", userOrderList);
    }

    public static void getUsernameFromModel(Model model, int id) {
        String username;
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();
            Query getUserCard = session.createQuery("SELECT userCard FROM User where id=:id");
            getUserCard.setParameter("id", id);
            List list = getUserCard.getResultList();
            if (list.isEmpty()) return;
            UserCard userCard = (UserCard) list.get(0);
            username = userCard.getSurname() + " " + userCard.getName();
        }
        model.addAttribute("username", username);
    }


    public static void saveOrderUser(String nameOrder, String description, String sphere) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query findUser = session.createQuery("FROM User Where id =: id");
            findUser.setParameter("id", 1);

            User user = (User) findUser.getResultList().get(0);

            UserOrder userOrder = new UserOrder();

            userOrder.setNameOrder(nameOrder);
            userOrder.setStatus(Const.statesOrder.get(2));
            userOrder.setDescriptionOrder(description);
            userOrder.setUser(user);

            session.save(userOrder);

            session.getTransaction().commit();


        }
    }

    public static void saveOrderToAvailable(String nameOrder, String description, String sphere) {
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();

            AvailableOrder availableOrder = new AvailableOrder();

            availableOrder.setNameOrder(nameOrder);
            availableOrder.setDescriptionOrder(description);
            availableOrder.setStatus(Const.statesOrder.get(2));

            SphereActivity sphereActivity = new SphereActivity();
            sphereActivity.setNameActivity(sphere);
            availableOrder.setSphereActivity(sphereActivity);

            session.merge(availableOrder);

            session.getTransaction().commit();


        }
    }

    public static void deleteOrderUser(String nameOrder, String status, String description) {

        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM UserOrder WHERE nameOrder =: nameOrder AND status =: status AND descriptionOrder =: description");
            query.setParameter("nameOrder", nameOrder);
            query.setParameter("status", status);
            query.setParameter("description", description);
            query.executeUpdate();
            session.getTransaction().commit();
        }


    }
}
