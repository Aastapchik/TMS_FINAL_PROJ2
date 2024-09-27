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
@Table(name = "available_orders")
public class AvailableOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;

    @Column(name = "name_order")
    private String nameOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "description_order")
    private String descriptionOrder;

    @ManyToOne(optional=true, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fk_sphere_activity")
    private SphereActivity sphereActivity;

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(
//            name = "aorders_sphere",
//            joinColumns = {@JoinColumn(name = "aorders_id")},
//            inverseJoinColumns = {@JoinColumn(name = "sphere_id")}
//    )
//    List<SphereActivity> sphereActivityList = new ArrayList<>();

    @Override
    public String toString() {
        return "AvailableOrder{" +
                "id=" + id +
                ", nameOrder='" + nameOrder + '\'' +
                '}';
    }
}
