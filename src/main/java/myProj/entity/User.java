package myProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usrs")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password_usr")
    private String password;

    @Column(name = "role_usr")
    private String role;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "usrs_sphere",
            joinColumns = {@JoinColumn(name = "usrs_id")},
            inverseJoinColumns = {@JoinColumn(name = "sphere_id")}
    )
    List<SphereActivity> sphereActivityList = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "usrs_aorders",
            joinColumns = {@JoinColumn(name = "usrs_id")},
            inverseJoinColumns = {@JoinColumn(name = "aorder_id")}
    )
    List<AvailableOrder> availableOrdersList = new ArrayList<>();


    @OneToOne(optional = false, mappedBy = "user")
    private UserCard userCard;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserAOrder> userAOrders;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserOrder> userOrders = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserReview> userReviews = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "master", fetch = FetchType.LAZY)
    private List<UserOrder> masterOrders = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", sphereActivityList=" + sphereActivityList.size() +
                //   ", availableOrdersList=" + availableOrdersList.size() +
                ", userCard=" + userCard +
                ", userAOrders=" + userAOrders.size() +
                ", userOrders=" + userOrders.size() +
                ", userReviews=" + userReviews.size() +
                '}';
    }
}
