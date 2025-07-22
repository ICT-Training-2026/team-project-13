package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;
import com.example.demo.entity.LoginResult;
import com.example.demo.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
	
	@Autowired
    private final LoginRepository loginRepository;

	@Override
	public LoginResult checkLogin(Login login) {
		
		
		LoginResult lr = new LoginResult();
		Account account = loginRepository.findByLogin(login);
		
		
		
		if(account!=null) {
			lr.setActive(true);
			lr.setAuthority(account.getAuthority());
			
		}
		else {
			lr.setActive(false);
		}
		
//		lr.setActive(true);
//		lr.setRole(null);
		
		return lr;
	}

}
