package myProj.dataBase.request.user;

import myProj.dataBase.AppCfg;
import myProj.entity.UserCard;
import myProj.entity.UserOrder;
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

    public static void getUserOrderFromModel(Model model, int id){
        List<UserOrder> userOrderList;
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();
            Query getUserOrderList = session.createQuery("SELECT userOrders FROM User where id=:id ");
            getUserOrderList.setParameter("id", id);
            userOrderList = getUserOrderList.getResultList();

        }
        System.out.println(userOrderList);
        model.addAttribute("orders", userOrderList);
    }

    public static void getUsernameFromModel(Model model, int id){
        String username;
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();
            Query getUserCard = session.createQuery("SELECT userCard FROM User where id=:id");
            getUserCard.setParameter("id", id);
            UserCard userCard = (UserCard) getUserCard.getResultList().get(0);
            username = userCard.getSurname() + " " + userCard.getName();
        }
        model.addAttribute("username", username);
    }




}
