package com.youjin.service;

import com.youjin.domain.user.User;
import com.youjin.domain.user.UserRepository;
import com.youjin.payload.request.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService{

    private final UserRepository userRepository;

    public String signup(UserRequest request){
        userRepository.save(User.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .build());
            return "Success";
        }


    public String login(String userName, String password) {
        Optional<User> user = userRepository.findByUserId(userName);
        if(user.get().getPassword().equals(password)) {
            return "Success";
        }
        return "Failed";
    }


}