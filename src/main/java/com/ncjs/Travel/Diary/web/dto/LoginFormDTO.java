package com.ncjs.Travel.Diary.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull(message = "username is required.")
    @NotBlank(message = "username is required.")
    @Size(min = 3, max = 20,
        message = "Invalid username. Must be between 3 and 20 characters.")
    private String username;

    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 30,
        message = "Invalid password. Must be between 6 and 30 characters.")
    private String password;

    // getters and setters
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}