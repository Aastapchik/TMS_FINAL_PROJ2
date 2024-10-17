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
@Table(name = "sphere_of_activity")
public class SphereActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;

    @Column(name = "name_of_activity")
    private String nameActivity;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sphereActivity", fetch = FetchType.LAZY)
    private List<AvailableOrder> availableOrderList = new ArrayList<>();

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<UserAOrder> userAOrders = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sphereActivity", fetch = FetchType.LAZY)
    private List<UserOrder> userOrders = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sphereActivity", fetch = FetchType.LAZY)
    private List<UserCard> userCards = new ArrayList<>();

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(
//            name = "aorders_sphere",
//            joinColumns = {@JoinColumn(name = "sphere_id")},
//            inverseJoinColumns = {@JoinColumn(name = "aorders_id")}
//    )
//    List<AvailableOrder> availableOrderList = new ArrayList<>();

    @Override
    public String toString() {
        return "SphereActivity{" +
                "id=" + id +
                ", nameActivity='" + nameActivity + '\'' +
                '}';
    }
}
