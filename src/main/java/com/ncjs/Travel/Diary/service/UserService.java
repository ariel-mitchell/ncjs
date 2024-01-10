package com.ncjs.Travel.Diary.service;

        import com.ncjs.Travel.Diary.models.User;
        import com.ncjs.Travel.Diary.web.dto.UserRegistrationDto;

public interface UserService {

    // method to save registration information
    User save(UserRegistrationDto registrationDto);

}
