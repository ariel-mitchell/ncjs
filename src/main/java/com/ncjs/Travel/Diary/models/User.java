//making dummy user field so as to conceptualize code: fix and replace with cheri's code later since her feature is account creation
//so this user will extend abstract entity which will hold a unique id. It includes username and password that will be able to be retrieved via security questions.
// consider making password "set" if i want to reset password and not have password be retrieved? something to think about.
package com.ncjs.Travel.Diary.models;
//import com.ncjs.Travel.Diary.models.AbstractEntity;
import com.ncjs.Travel.Diary.models.PasswordSecurityQuestions;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    @Entity
    public class User extends AbstractEntity {
        //setting password specific security questions to user in database as a 1:1
        //setting it to "valid" to check the insides (specific questions) of the passwordsecurityquestions
        //making it "Not null" to check that it is not null since it is necessary for mandatory password recovery service

        //    @OneToMany
//    private Trip Trip; ????????????
        @Id
        @GeneratedValue
        public int id;
        @OneToOne(cascade = CascadeType.ALL)
        @Valid
        private PasswordSecurityQuestions passwordSecurityQuestions;
        @OneToOne(cascade = CascadeType.ALL)
        @Valid
        private PersonalQuestions personalQuestions;
        @NotNull
        private String username;

        @NotNull
        private String pwHash;

        @NotNull
        private String email;

        public User() {
        }

        public User(String username, String password, String email,PasswordSecurityQuestions passwordSecurityQuestions) {
            this.username = username;
            this.pwHash = encoder.encode(password);
            this.email = email;
            this.passwordSecurityQuestions = passwordSecurityQuestions;
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
        public void resetPassword(String password) {
            this.pwHash = encoder.encode(password);
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

        public PersonalQuestions getPersonalQuestions() {
            return personalQuestions;
        }

        public void setPersonalQuestions(PersonalQuestions personalQuestionsQuestions) {
            this.personalQuestions = personalQuestions;
        }

        // methods
        private static final BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        public boolean isMatchingPassword(String password) {
            return encoder.matches(password, pwHash);
        }

    }