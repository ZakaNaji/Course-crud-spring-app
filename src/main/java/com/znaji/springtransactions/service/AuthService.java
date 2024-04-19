package com.znaji.springtransactions.service;

import org.springframework.stereotype.Service;


public interface AuthService {
    boolean login(String username, String password);
    boolean logout();
    boolean register(String username, String password);
}
