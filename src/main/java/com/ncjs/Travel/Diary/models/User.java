// Used to get at the data in the user table
package com.ncjs.Travel.Diary.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private String email;

    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
    }

    // getters and setters
    public String getUsername( ) {
        return username;
    }
// TODO - figure out why the compiler thinks this line needs a return statement
    //    public String setUsername(String username) { this.username = username; }

    public String getEmail( ) { return email; }
    public void setEmail(String email) { this.email = email; }

    // methods
    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }



}
