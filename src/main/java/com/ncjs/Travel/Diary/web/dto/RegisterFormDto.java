package com.ncjs.Travel.Diary.web.dto;

import jdk.javadoc.internal.doclets.toolkit.util.DocPath;

public class RegisterFormDto extends LoginFormDTO {

    private String confirmPassword;
    private String email;
    private Boolean verified;

    public String getVerifyPassword() {return confirmPassword;}

    public void setVerifyPassword(String verifyPassword) {
        this.confirmPassword = verifyPassword;
    }

    // null constructor
    public RegisterFormDto() { }

    // parameterized constructor
    // TODO - Does this need fixing to inherit correctly
    public RegisterFormDto(String userName, String password,
                           String confirmPassword, String email,
                           Boolean verified) {
        super();
//        this.userName = userName;
//        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.verified = verified;
    }

    // getters and setters
    // TODO figure out how to get inherited username and password
    // These should come from the parent
    public String getUsername() {return DocPath.parent.getUsername();}
    public void setUsername(String username) {
        this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    // TODO - end

    // These should come from this class
    public String getConfirmPassword( ) { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getVerified( ) { return verified; }
    public void setVerified(Boolean verified) { this.verified = verified; }

}
