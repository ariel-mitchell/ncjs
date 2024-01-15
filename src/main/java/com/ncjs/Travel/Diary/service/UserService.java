package com.ncjs.Travel.Diary.service;

        import com.ncjs.Travel.Diary.models.User;
        import com.ncjs.Travel.Diary.web.dto.RegisterFormDto;
        import org.springframework.stereotype.Service;


@Service
public interface UserService {

    // method to save registration information
    User save(RegisterFormDto registrationDto);

}
