package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final JdbcTemplate jdbcTemplate;
	@Override
	public void add(User user) {
		
		String sql =
				"INSERT INTO employee_info " +
		"(employee_id, name, department_id, pass, authority)" +
	    "values(?,?,?,?,?)";
		
		jdbcTemplate.update(sql, user.getEmployeeId(),
				                 user.getName(),
				                 user.getDepartmentId(),
				                 user.getPass(),
				                 user.getAuthority());

	}

}
