package com.tapestry.pages;

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

    void onValidateFromLogin()
    {
        if (!userName.equals("sahil@gmail.com"))
            login.recordError(userNameField, "Try with user: sahil@gmail.com");

        if (!password.equals("password"))
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
