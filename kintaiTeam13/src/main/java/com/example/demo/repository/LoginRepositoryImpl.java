package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Login;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {
	
	  public final JdbcTemplate jdbcTemplate;

	@Override
	public Account findByLogin(Login login) {
		 String sql = "  SELECT EMPLOYEE_ID, NAME, DEPARTMENT_ID, PASS, AUTHORITY FROM EMPLOYEE_INFO WHERE EMPLOYEE_ID = ? AND PASS = ?  ";

	        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, login.getUserId(), login.getPass());

	        if (list.isEmpty()) {
	            return null;
	        }

	        Map<String, Object> one = list.get(0);
	        Account account = new Account();
	        account.setEmployeeId((String) one.get("EMPLOYEE_ID"));
	        account.setName((String)one.get("NAME"));
//	        account.setDepartmentId((String) one.get("DEPARTMENT_ID"));
	        account.setDepartmentId(((Integer) one.get("DEPARTMENT_ID")).intValue());
	        account.setPassword((String) one.get("PASS"));
	        account.setAuthority((String) one.get("AUTHORITY"));
//	        account.setPaidLeaveDays(((BigDecimal) one.get("PAID_LEAVE_DAYS")).doubleValue());


	        return account;	}

}
