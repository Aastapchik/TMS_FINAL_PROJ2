package myProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "usrs_order")
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;

    @Column(name = "name_of_order")
    private String nameOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String descriptionOrder;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_usrs_order")
    private User user;

    @ManyToOne(optional=true, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fk_executor_id")
    private User master;

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", nameOrder='" + nameOrder + '\'' +
                ", user=" + user +
                '}';
    }
}
