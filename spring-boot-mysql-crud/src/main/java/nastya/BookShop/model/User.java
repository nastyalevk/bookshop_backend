package nastya.BookShop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @OneToMany(mappedBy = "userRolesId.user")
    @JsonIgnore
    private Set<UserRoles> userRoles;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Review> review;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Shop> shop;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Order> order;

    @Column(name = "username")
    private String userName;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public User(){}
}