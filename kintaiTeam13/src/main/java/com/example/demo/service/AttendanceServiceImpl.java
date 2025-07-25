package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.repository.AttendanceRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService{

	private final AttendanceRepository repository;

	@Override
	public void regist(Attendance attendance) {
		repository.add(attendance);
	}
}
