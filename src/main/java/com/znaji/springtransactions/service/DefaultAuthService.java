package com.znaji.springtransactions.service;

import org.springframework.stereotype.Service;

@Service
public class DefaultAuthService implements AuthService{
    @Override
    public boolean login(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        return false;
    }
}
