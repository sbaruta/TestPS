package com.testrbc.petshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Roles {
    public final String ADMIN;
    public final String USERS;

    @Autowired
    public Roles(Environment env) {
        ADMIN = env.getProperty("stormpath.authorized.group.admin");
        USERS = env.getProperty("stormpath.authorized.group.users");
    }
}