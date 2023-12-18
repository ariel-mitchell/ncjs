package com.ncjs.Travel.Diary;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class PasswordSecurityQuestions extends AbstractEntity {

    @Size(max = 100, message = "Please enter up to 100 characters")
    @NotBlank(message = "Required field, if unknown, please put 'unknown'")
    private String momMaidenName;
    @Size(max = 100, message = "Please enter up to 100 characters")
    @NotBlank(message = "Required field, if unknown, please put 'unknown'")
    private String birthLocation;

    @Size(max = 100, message = "Please enter up to 100 characters")
    @NotBlank(message = "Required field. If unknown, please put 'unknown'")
    private String firstKiss;
    @Size(max = 100, message = "Please enter up to 100 characters")
    @NotBlank(message = "Required field, if unknown, please put 'unknown'")
    private String firstLocation;

    @Size(max = 100, message = "Please enter up to 100 characters")
    @NotBlank(message = "Required field, if unknown, please put 'unknown'")
    private String firstWord;

    public PasswordSecurityQuestions(String momMaidenName, String birthLocation, String firstKiss, String firstLocation, String firstWord) {
        this.momMaidenName = momMaidenName;
        this.birthLocation = birthLocation;
        this.firstKiss = firstKiss;
        this.firstLocation = firstLocation;
        this.firstWord = firstWord;
    }

    public  PasswordSecurityQuestions() {};

    public String getMomMaidenName() {
        return momMaidenName;
    }

    public void setMomMaidenName(String momMaidenName) {
        this.momMaidenName = momMaidenName;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public String getFirstKiss() {
        return firstKiss;
    }

    public void setFirstKiss(String firstKiss) {
        this.firstKiss = firstKiss;
    }

    public String getFirstLocation() {
        return firstLocation;
    }

    public void setFirstLocation(String firstLocation) {
        this.firstLocation = firstLocation;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }
}
