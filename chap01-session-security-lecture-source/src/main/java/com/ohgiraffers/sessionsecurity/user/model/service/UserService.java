package com.ohgiraffers.sessionsecurity.user.model.service;

import com.ohgiraffers.sessionsecurity.user.model.dao.UserMapper;
import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public int regist(SignupDTO signupDTO) {

        String pw = signupDTO.getUserPass();
        signupDTO.setUserPass(passwordEncoder.encode(pw));
        int result = 0;
        try {
            result = userMapper.regist(signupDTO);
        } catch (Exception e) {
            e.printStackTrace();        // 예외가 발생 했을 떄, 발생한 위치와 상태를 반환하는 메소드
        }

        return result;
    }

    public LoginUserDTO findByUsername(String username) {

        LoginUserDTO login = userMapper.findByUsername(username);

        if(!Objects.isNull(login)){
            return login;
        } else {
            return null;
        }

    }
}
