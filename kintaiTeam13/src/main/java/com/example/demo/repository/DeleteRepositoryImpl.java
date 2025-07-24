package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DeleteRepositoryImpl implements DeleteRepository {
	
	public final JdbcTemplate jdbcTemplate;

	@Override
	public void deleteStamp(int registId) {
		
		String sql =
				" DELETE              " + 
				" FROM                " + 
				"  attendance_info    " + 
				" WHERE               " + 
				"   REGIST_ID = ?     "; 
		
		jdbcTemplate.update(sql, registId);
	}

}
