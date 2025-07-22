package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.entity.LoginResult;

public interface LoginService {

	LoginResult checkLogin(Login login);
}
