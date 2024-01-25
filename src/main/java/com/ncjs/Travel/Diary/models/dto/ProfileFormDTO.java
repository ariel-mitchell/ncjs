package com.ncjs.Travel.Diary.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class ProfileFormDTO {

    @Size(min = 3, max = 20,
            message = "Username must be between 3 and 20 characters.")
    private String username;

    @Size(min = 6, max = 20,
            message = "Password must be between 6 and 20 characters.")
    private String password;

    @Size(min = 6, max = 20,
            message = "Password must be between 6 and 20 characters.")
    private String verifyPassword;

    @Size(min = 6, max = 30,
            message = "Email address must be between 6 and 30 characters.")
    @Email(message = "Invalid email. Try again.")
    private String email;

    // getters and setters
    public String getUsername( ) { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword( ) { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword( ) { return verifyPassword; }
    // no need to set verifyPassword because we are not saving it
//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//    }

    public String getEmail( ) { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

}
