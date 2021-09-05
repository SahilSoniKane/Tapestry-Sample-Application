package com.tapestry.services;

public interface LoginService {
    boolean isValidUserName(String userName);
    boolean isValidPassword(String password);
}
