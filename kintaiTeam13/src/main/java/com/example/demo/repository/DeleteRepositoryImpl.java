package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DeleteRepositoryImpl implements DeleteRepository {
	
	public final JdbcTemplate jdbcTemplate;

//	@Override
//	public void deleteStamp(int registId) {
//		
//		String sql =
//				" DELETE              " + 
//				" FROM                " + 
//				"  attendance_info    " + 
//				" WHERE               " + 
//				"   REGIST_ID = ?     "; 
//		
//		jdbcTemplate.update(sql, registId);
//	}
//
//}
	@Override
	public void deleteStamp(int registId) {
	    // SQL to check if the status_id is 2, 3, or 4
	    String checkStatusSql = 
	            "SELECT status_id FROM attendance_info " +
	            "WHERE REGIST_ID = ?";

	    // Get the status_id for the given registId
	    Integer statusId = jdbcTemplate.queryForObject(checkStatusSql, Integer.class, registId);

	    if (statusId != null) {
	        if (statusId == 2) {
	            // If status_id is 2, decrement furi_holiday in dayoff table
	            String updateDayoffSql = 
	                    "UPDATE dayoff " +
	                    "SET furi_holiday = furi_holiday - 1 " +
	                    "WHERE employee_id = (SELECT employee_id FROM attendance_info WHERE REGIST_ID = ?)";

	            jdbcTemplate.update(updateDayoffSql, registId);
	        } else if (statusId == 3) {
	            // If status_id is 3, increment furi_holiday in dayoff table
	            String updateDayoffSql = 
	                    "UPDATE dayoff " +
	                    "SET furi_holiday = furi_holiday + 1 " +
	                    "WHERE employee_id = (SELECT employee_id FROM attendance_info WHERE REGIST_ID = ?)";

	            jdbcTemplate.update(updateDayoffSql, registId);
	        } else if (statusId == 4) {
	            // If status_id is 4, increment yu_holiday in dayoff table
	            String updateDayoffSql = 
	                    "UPDATE dayoff " +
	                    "SET yu_holiday = yu_holiday + 1 " +
	                    "WHERE employee_id = (SELECT employee_id FROM attendance_info WHERE REGIST_ID = ?)";

	            jdbcTemplate.update(updateDayoffSql, registId);
	        }
	    }

	    // SQL to delete the record
	    String deleteSql = 
	            "DELETE FROM attendance_info " +
	            "WHERE REGIST_ID = ?";

	    jdbcTemplate.update(deleteSql, registId);
	}
}