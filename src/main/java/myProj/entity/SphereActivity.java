package myProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
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

    @Override
    public String toString() {
        return "SphereActivity{" +
                "id=" + id +
                ", nameActivity='" + nameActivity + '\'' +
                '}';
    }
}
