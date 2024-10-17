package myProj.dataBase.request.user;

import myProj.entity.*;
import myProj.localMemory.Const;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

import static myProj.dataBase.AppCfg.entityManagerFactory;

@Component
public class UserRequestDB {

    private static SessionFactory sf = entityManagerFactory();
    private static Transaction tr = sf.getCurrentSession().beginTransaction();


    public static void getUserOrderFromModel(Model model, int id) {
        List<UserOrder> userOrderList;
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();
            Query getUserOrderList = session.createQuery("SELECT userOrders FROM User where id=:id ");
            getUserOrderList.setParameter("id", id);
            userOrderList = getUserOrderList.getResultList();
            session.getTransaction().commit();

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
            session.getTransaction().commit();
        }
        model.addAttribute("username", username);
    }


    public static void saveOrderUser(String nameOrder, String description, String sphere, int id) {
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query getSphere = session.createQuery("FROM SphereActivity WHERE nameActivity =: sphere");
            getSphere.setParameter("sphere", sphere);
            SphereActivity sphereActivity = (SphereActivity) getSphere.getResultList().get(0);

            Query findUser = session.createQuery("FROM User Where id =: id");
            findUser.setParameter("id", id);

            User user = (User) findUser.getResultList().get(0);


            UserOrder userOrder = new UserOrder();

            userOrder.setNameOrder(nameOrder);
            userOrder.setStatus(Const.STATES_ORDER.get(2));
            userOrder.setDescriptionOrder(description);
            userOrder.setUser(user);
            userOrder.setSphereActivity(sphereActivity);
            session.persist(userOrder);

            session.getTransaction().commit();


        }
    }

//    public static void saveOrderToAvailable(String nameOrder, String description, String sphere) {
//        try (Session session = sf.getCurrentSession()) {
//
//            session.beginTransaction();
//
//            AvailableOrder availableOrder = new AvailableOrder();
//
//            availableOrder.setNameOrder(nameOrder);
//            availableOrder.setDescriptionOrder(description);
//            availableOrder.setStatus(Const.statesOrder.get(2));
//
//            SphereActivity sphereActivity = new SphereActivity();
//            sphereActivity.setNameActivity(sphere);
//            availableOrder.setSphereActivity(sphereActivity);
//
//            session.merge(availableOrder);
//
//            session.getTransaction().commit();
//
//        }
//    }

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

    public static void getUserCardFromModel(Model model, int id) {
        UserCard userCard;
        try (Session session = sf.getCurrentSession()) {

            session.beginTransaction();
            Query getUserCard = session.createQuery("SELECT userCard FROM User where id=:id ");
            getUserCard.setParameter("id", id);

            userCard = (UserCard) getUserCard.getResultList().get(0);
            session.getTransaction().commit();
        }
        model.addAttribute("userCard", userCard);
    }


    public static void updateUserCard(String name, String surname, String sphere, String description, int id) {


        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
//            Query getSphere = session.createQuery("FROM SphereActivity WHERE nameActivity =: sphere");
//            getSphere.setParameter("sphere", sphere);
//            SphereActivity sphereAct = (SphereActivity) getSphere.getResultList().get(0);
            Query findUser = session.createQuery("FROM User Where id =: id");
            findUser.setParameter("id", id);
            User user = (User) findUser.getResultList().get(0);
            UserCard userCard = user.getUserCard();

            if (!description.isEmpty()) userCard.setDescription(description);
            else userCard.setDescription(user.getUserCard().getDescription());

            if (!name.isEmpty()) userCard.setName(name);
            else userCard.setName(user.getUserCard().getName());

            if (!surname.isEmpty()) userCard.setSurname(surname);
            else userCard.setSurname(user.getUserCard().getSurname());

//            if(!sphere.isEmpty()) userCard.setSphereActivity(sphereAct);
//            else userCard.setSphereActivity(user.getUserCard().getSphereActivity());

            userCard.setNumStar(user.getUserCard().getNumStar());
            user.setUserCard(userCard);

            session.update(user);
            session.getTransaction().commit();
        }

    }

    public static int[] getGradeUser(int id) {
        int[] scores;
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query findUser = session.createQuery("Select userReviews FROM User Where id =: id");
            findUser.setParameter("id", id);
            List<UserReview> userReviewsList = findUser.getResultList();
            scores = new int[userReviewsList.size()];
            for (int i = 0; i < userReviewsList.size(); i++) scores[i] = userReviewsList.get(i).getGrade();
            session.getTransaction().commit();

        }
        return scores;

    }

    public static void addToModelUserReview(Model model, int id) {
        List<UserReview> userReviewsList;
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query findUserReview = session.createQuery("Select userReviews FROM User Where id =: id");
            findUserReview.setParameter("id", id);
            userReviewsList = findUserReview.getResultList();
            session.getTransaction().commit();


        }
        if (userReviewsList.size() % 2 == 1) {
            UserReview userReview = new UserReview();
            userReview.setGrade(6);
            userReviewsList.add(userReview);
        }
        model.addAttribute("userReviewsList", userReviewsList);

    }

    public static User findUserByUsername(String username) {
        User user = null;
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query findUser = session.createQuery("FROM User Where login =: username");
            findUser.setParameter("username", username);
            if (!findUser.getResultList().isEmpty()) user = (User) findUser.getResultList().get(0);
            session.getTransaction().commit();
        }
        return user;
    }

    public static void addReviewFromUser(int idUser, String review, int grade){
        try (Session session = sf.getCurrentSession()) {
            session.beginTransaction();
            Query findUser = session.createQuery("FROM User Where id =: id");
            findUser.setParameter("id", idUser);
            User client = (User) findUser.getResultList().get(0);
            UserReview userReview = new UserReview();
            userReview.setReview(review);
            userReview.setUser(client);
            userReview.setGrade(grade);
            session.save(userReview);

            session.getTransaction().commit();
        }
    }


}
