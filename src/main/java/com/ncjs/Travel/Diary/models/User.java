// Used to get at the data in the user table
package com.ncjs.Travel.Diary.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.ncjs.Travel.Diary.controllers.AuthenticationController.encoder;


@Entity
// TODO - Don't require email to be unique - address later
public class User extends AbstractEntity {

//    @NotNull(message = "User Name is required.")
//    @NotBlank(message = "User Name is required.")
//    @Size(max = 25, message = "Maximum Name length is 25 characters.")
//    @Column(name = "user_name")
    @NotNull
    private String username;

    @NotBlank(message = "Password is required.")
    @NotNull(message = "Password is required.")
    @Size(max = 25, message = "Password is too many characters.")
    @NotNull
    private String password;

    @NotBlank(message = "Email is required.")
    @NotNull(message = "Email is required.")
    @Size(max = 50, message = "Maximum Email length is 50 characters.")
    @Email(message = "Invalid email. Try again.")
    @NotNull
    private String email;

    public static BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    // constructors
    public User() { }

    // Initialize the id and value fields.
    public User(String username, String password, String email) {
        super();
        this.username = username;
        this.password = encoder.encode(password);
        this.email = email;
    }

    // getters and setters
    public String getUsername( ) { return username; }
    public void setUsername(String userName) { this.username = username; }

    public String getPassword( ) { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }

    // methods
    public boolean isMatchingPassword(String password) {
        return getEncoder().matches(password, this.password);
    }

    public boolean isPasswordEmpty() {
        return password == null || password.isEmpty();
    }

}
