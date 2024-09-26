package myProj.dataBase;

import myProj.entity.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCfg {

    @Bean
    public static SessionFactory entityManagerFactory() {
        return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(AvailableOrder.class)
                .addAnnotatedClass(SphereActivity.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserAOrder.class)
                .addAnnotatedClass(UserCard.class)
                .addAnnotatedClass(UserOrder.class)
                .addAnnotatedClass(UserReview.class)
                .buildSessionFactory();
    }
}


