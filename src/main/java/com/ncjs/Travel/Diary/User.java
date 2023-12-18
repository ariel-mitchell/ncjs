//making dummy user field so as to conceptualize code: fix and replace with cheri's code later since her feature is account creation
//so this user will extend abstract entity which will hold a unique id. It includes username and password that will be able to be retrieved via security questions.
// consider making password "set" if i want to reset password and not have password be retrieved? something to think about.
package com.ncjs.Travel.Diary;
import jakarta.persistence.CascadeType;
import jakarta.validation.Valid;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
    @Entity
    public class User extends AbstractEntity {
    //setting password specific security questions to user in database as a 1:1
    //setting it to "valid" to check the insides (specific questions) of the passwordsecurityquestions
    //making it "Not null" to check that it is not null since it is necessary for mandatory password recovery service
     @OneToOne (cascade = CascadeType.ALL)
     @Valid
     @NotNull
        private PasswordSecurityQuestions passwordSecurityQuestions;
        @NotNull
        private String username;

        @NotNull
        private String pwHash;

        @NotNull
        private String email;



        public User() {}

        public User(String username, String password, String email) {
            this.username = username;
            this.pwHash = password;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getPwHash() {
            return pwHash;
        }
        public void setPwHash(String pwHash) {
            this.pwHash = pwHash;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public PasswordSecurityQuestions getPasswordSecurityQuestions() {
            return passwordSecurityQuestions;
        }
        public void setPasswordSecurityQuestions(PasswordSecurityQuestions passwordSecurityQuestions) {
            this.passwordSecurityQuestions = passwordSecurityQuestions;
        }

    }
