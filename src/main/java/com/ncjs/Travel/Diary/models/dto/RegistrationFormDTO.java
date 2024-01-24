package com.ncjs.Travel.Diary.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegistrationFormDTO extends LoginFormDTO {

    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 20,
            message = "Invalid Password. Must be between 6 and 20 characters.")
    private String verifyPassword;

    public String getVerifyPassword( ) { return verifyPassword; }
    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}
