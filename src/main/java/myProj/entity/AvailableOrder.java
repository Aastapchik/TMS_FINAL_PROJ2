package myProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Override
    public String toString() {
        return "AvailableOrder{" +
                "id=" + id +
                ", nameOrder='" + nameOrder + '\'' +
                '}';
    }
}
