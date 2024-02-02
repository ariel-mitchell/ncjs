package com.ncjs.Travel.Diary.dto;

import com.ncjs.Travel.Diary.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PasswordRecoveryDTO {
    //user
    //password =reset password
    //verify password

    @NotNull
    private User user;

    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 20,
            message = "Invalid Password. Must be between 6 and 20 characters.")
    private String password;

    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 20,
            message = "Invalid Password. Must be between 6 and 20 characters.")
    private String verifyPassword;

}
