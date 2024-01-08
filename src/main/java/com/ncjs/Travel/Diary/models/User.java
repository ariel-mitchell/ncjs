package com.ncjs.Travel.Diary.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
// Would rather that email not be required to be unique - address later?
//@Table(name = "user")
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity {

// The following lines are in AbstractEntity
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "user_name")
    @NotBlank(message = "User Name is required.")
    @NotNull(message = "User Name is required.")
    @Size(max = 25, message = "Maximum Name length is 25 characters.")
    private String userName;

    @NotBlank(message = "Password is required.")
    @NotNull(message = "Password is required.")
    @Size(max = 25, message = "Password is too many characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    @NotNull(message = "Confirm password is required.")
    @Size(max = 25, message = "Confirm password is too many characters.")
    private String confirmPassword;

    @NotBlank(message = "Email is required.")
    @NotNull(message = "Email is required.")
    @Size(max = 50, message = "Maximum Email length is 50 characters.")
    private String email;

    private Boolean verified;

    @OneToMany
    @JoinColumn(name = "user_id")
    private final List<Trip> trips = new ArrayList<>();

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_trips",
//            joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id"))
    // if it was a @ManyToMany relationship, add the commented lines below:
    //      inverseJoinColumns = @JoinColumn(
    //                      name = "trip_id", referencedColumnName = "id"))

//    private Collection<Trips> trips;

    // constructors
    public User() { }

    // Initialize the id and value fields.
    public User(Integer userId, String userName, String password, String email,
                List<Trip> atrip, Boolean verified) {
        super();
//        if (Objects.equals(password, confirmPassword)) {
// TODO how do I get the id from super into this.userId or do I have to just call the field "id"?
//        this.userId = ?;
//        if (password == confirmPassword) {
            this.userName = userName;
            this.password = password;
            this.email = email;
//            this.trip = atrip;
            this.verified = false;
//            return "/login";
//        } else {
//            model.addAttribute("message", "Password and Confirm password must match.");
//            return "/add";
//        }
    }

    // getters and setters

    public String getUsername( ) { return userName; }

    public void setUsername(String userName) { this.userName = userName; }

    public String getPassword( ) { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail( ) { return email; }

    public void setEmail(String email) { this.email = email; }

    public Boolean getVerified( ) { return verified; }

    public void setVerified(Boolean verified) { this.verified = verified; }

    public Collection<Trip> getTrips() { return trips; }

//    public void setTrips(List<Trip> trips) { this.trips = trips; }

}
