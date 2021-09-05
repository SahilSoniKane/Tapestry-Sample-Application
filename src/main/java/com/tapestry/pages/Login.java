package com.tapestry.pages;

import com.tapestry.services.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Login
{
    private static final Logger logger = LogManager.getLogger(Login.class);

    @Inject
    private AlertManager alertManager;

    @InjectComponent
    private Form login;

    @InjectComponent("username")
    private TextField userNameField;

    @InjectComponent("password")
    private PasswordField passwordField;

    @Property
    private String userName;

    @Property
    private String password;

    @Inject
    private LoginService loginService;

    void onValidateFromLogin()
    {
        if (!loginService.isValidUserName(userName))
            login.recordError(userNameField, "Try with user: test@gmail.com");

        if (!loginService.isValidPassword(password))
            login.recordError(passwordField, "Try with password: password");
    }

    Object onSuccessFromLogin()
    {
        logger.info("Login successful!");
        alertManager.success("Welcome aboard!");
        return Employees.class;
    }

    void onFailureFromLogin()
    {
        logger.warn("Login error!");
        alertManager.error("Invalid Credentials!!! Please try again");
    }
}
