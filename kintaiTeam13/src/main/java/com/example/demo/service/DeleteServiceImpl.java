package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.DeleteRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class DeleteServiceImpl implements DeleteService {
	
	@Autowired
    private final DeleteRepository deleteRepository;

	@Override
	public void delete(int registId) {
		
		deleteRepository.deleteStamp(registId);

	}

}
