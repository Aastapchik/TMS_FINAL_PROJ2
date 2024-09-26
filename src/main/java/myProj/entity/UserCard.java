package myProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "usrs_card")
public class UserCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;

    @Column(name = "num_of_stars")
    private int numStar;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_card_usrs")
    private User user;

    @Override
    public String toString() {
        return "UserCard{" +
                "id=" + id +
                ", numStar=" + numStar +
                ", description='" + description + '\'' +
                //   ", user=" + user +
                '}';
    }
}
