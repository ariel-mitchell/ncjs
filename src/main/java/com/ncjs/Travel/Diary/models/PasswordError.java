package com.ncjs.Travel.Diary.models;

public class PasswordError extends Exception {
//    public String message = "Not a valid answer";
    public PasswordError() {
    }
    // Constructor that accepts a message
    public PasswordError(String message){
        super(message);
}

}
