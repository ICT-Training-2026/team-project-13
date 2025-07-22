package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;

public interface LoginRepository {
    Account findByLogin(Login login);
}
