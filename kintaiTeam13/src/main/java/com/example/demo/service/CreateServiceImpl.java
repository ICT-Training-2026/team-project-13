package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateServiceImpl implements CreateService {
	
	private final UserRepository repository;

	@Override
	public void create(User user) {
		repository.add(user);
	}

}
