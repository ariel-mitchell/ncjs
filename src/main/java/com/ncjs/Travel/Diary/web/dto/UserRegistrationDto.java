package com.ncjs.Travel.Diary.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {

    private String userName;
    private String password;
    private String confirmPassword;
    private String email;
    private Boolean verified;

    // constructors
    // regular constructor

    // parameterized constructor
    public UserRegistrationDto(String userName, String password,
                               String confirmPassword, String email,
                               Boolean verified) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.verified = verified;
    }

    // getters and setters
    public String getUserName( ) { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword( ) { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword( ) { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getVerified( ) { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }

}
