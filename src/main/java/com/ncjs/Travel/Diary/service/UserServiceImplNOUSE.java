//// This is used to save user information to the MySQL database.
//package com.ncjs.Travel.Diary.service;
//
//import com.ncjs.Travel.Diary.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.ncjs.Travel.Diary.web.dto.RegisterFormDTO;
//import com.ncjs.Travel.Diary.models.User;
//
//@Service
//public class UserServiceImplNOUSE implements UserServiceNOUSE {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserServiceImplNOUSE(UserRepository userRepository) {
//        super();
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public User save(RegisterFormDTO registerFormDTO) {
//        User newUser = new User(
//                registerFormDTO.getUsername(),
//                encoder.encode(password),
//                registerFormDTO.getEmail()
//        );
//        return userRepository.save(user);
//
//    }
//
//}
