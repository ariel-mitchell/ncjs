package com.ncjs.Travel.Diary.web.dto;

public class RegisterFormDto extends LoginFormDTO {

    private String confirmPassword;
    private String email;
    private Boolean verified;

    // null constructor
    public RegisterFormDto() { }

    // parameterized constructor
    public RegisterFormDto(String userName, String password,
                           String confirmPassword, String email,
                           Boolean verified) {
        super();
//        this.userName = userName;
//        this.password = password;
// TODO is this confirmPassword even needed?
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
