// This is used to save user information to the MySQL database.
package com.ncjs.Travel.Diary.service;

import com.ncjs.Travel.Diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ncjs.Travel.Diary.web.dto.RegisterFormDto;
import com.ncjs.Travel.Diary.models.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(RegisterFormDto registrationDto) {
       User user = new User(registrationDto.getUsername(),
               registrationDto.getPassword(),
               registrationDto.getEmail(),
               registrationDto.getVerified());
        return userRepository.save(user);

    }

}
