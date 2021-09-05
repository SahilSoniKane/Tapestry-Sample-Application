package com.tapestry.services;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean isValidUserName(String userName) {
        return userName.equals("test@gmail.com");
    }

    @Override
    public boolean isValidPassword(String password) {
        return password.equals("password");
    }
}
