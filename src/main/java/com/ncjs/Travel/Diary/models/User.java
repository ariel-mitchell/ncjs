package com.ncjs.Travel.Diary.models;

import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class User extends AbstractEntity {

    @NotBlank(message = "User Name is required.")
    @NotNull(message = "User Name is required.")
    @Size(max = 50, message = "Maximum Name length is 50 characters.")
    private String userName;

    @NotBlank(message = "Password is required.")
    @NotNull(message = "Password is required.")
    @Size(max = 50, message = "Password is too many characters.")
    private String password;

    @NotBlank(message = "Confirm password is required.")
    @NotNull(message = "Confirm password is required.")
    @Size(max = 50, message = "Confirm password is too many characters.")
    private String confirmPassword;

    @NotBlank(message = "Email is required.")
    @NotNull(message = "Email is required.")
    @Size(max = 50, message = "Maximum Email length is 50 characters.")
    private String email;

    private Boolean verified;


    // constructors
    public User() {}

    // Initialize the id and value fields.
    public User(Integer userId, String userName, String password, String email, Boolean verified) {
        super();
//        if (Objects.equals(password, confirmPassword)) {
// TODO how do I get the id from super into this.userId or do I have to just call the field "id"?
//        this.userId = ?;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.verified = false;
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

}
