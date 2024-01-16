package com.ncjs.Travel.Diary.models;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
// Would rather that email not be required to be unique - address later?
//@Table(name = "user")
//@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends AbstractEntity {

//    @Column(name = "user_name")
//    @NotBlank(message = "User Name is required.")
//    @Size(max = 25, message = "Maximum Name length is 25 characters.")
    @NotNull(message = "User Name is required.")
    private String username;

    @NotNull
    private String pwHash;

    @NotBlank(message = "Password is required.")
    @NotNull(message = "Password is required.")
    @Size(max = 25, message = "Password is too many characters.")
    private String password;

//    @NotBlank(message = "Confirm password is required.")
//    @NotNull(message = "Confirm password is required.")
//    @Size(max = 25, message = "Confirm password is too many characters.")
//    private String confirmPassword;

    @NotBlank(message = "Email is required.")
    @NotNull(message = "Email is required.")
    @Size(max = 50, message = "Maximum Email length is 50 characters.")
    private String email;

    private Boolean verified;

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    // constructors
    public User() { }

    // Initialize the id and value fields.
    public User(String username, String password,
                String email, Boolean verified) {
        super();
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.verified = false;
    }

    //  constructor
    public User(String username, String password,
                String confirmPassword, String email, Boolean verified) {
        super();
    }

    public User(String username, String password) {
        super();
    }

    // getters and setters
    public String getUsername( ) { return username; }
    public void setUsername(String userName) { this.username = username; }

    public String getPassword( ) { return password; }
    public void setPassword(String password) { this.password = password; }

//    public String getConfirmPassword( ) { return confirmPassword; }
//    public void setConfirmPassword(String confirm_password) { this.confirmPassword = confirm_password; }

    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getVerified( ) { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }

//    public Collection<Trip> getTrips() { return trips; }

//    public void setTrips(List<Trip> trips) { this.trips = trips; }

    // methods
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
