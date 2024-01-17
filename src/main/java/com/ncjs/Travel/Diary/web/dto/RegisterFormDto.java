package com.ncjs.Travel.Diary.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterFormDto extends LoginFormDTO {

    @NotNull(message = "Confirm Password is required.")
    @NotBlank(message = "Confirm Password is required.")
    @Size(min = 6, max = 30,
        message = "Invalid password. Must be between 6 and 30 characters.")
    private String confirmPassword;

    @NotNull(message = "Email is required.")
    @NotBlank(message = "Email is required.")
    @Size(min = 6, max = 30,
        message = "Invalid Email. Must be between 6 and 30 characters.")
    private String email;

    private Boolean verified;

    // null constructor
    public RegisterFormDto() { }

    // parameterized constructor
    public RegisterFormDto(String userName, String password,
                           String confirmPassword, String email,
                           Boolean verified) {
        super();
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.verified = verified;
    }

    // getters and setters
    public String getConfirmPassword( ) { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getVerified( ) { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }

}
