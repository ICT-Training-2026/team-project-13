package com.example.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchResult;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SearchRepositoryImpl implements SearchRepository {
	
	public final JdbcTemplate jdbcTemplate;


	@Override
	public List<SearchResult> search(Search search) {
		
		String sql ="  SELECT REGIST_ID, EMPLOYEE_ID, STATUS_ID, WORK_DATE, START_TIME, END_TIME, BREAK_TIME, COMMENTS "
				+ " FROM attendance_info "
				+ " WHERE EMPLOYEE_ID = ? "
				+ " AND DATE_FORMAT(WORK_DATE, '%Y-%m') = ?;  ";
		
		// SQLで検索（プレースホルダ：引数で受け取ったrestaurantId）
		List<Map<String, Object>> list 
						= jdbcTemplate.queryForList(sql, search.getUserId(),search.getYearMonth());
		
		// 値の取得⇒結果の格納
		List<SearchResult> result = new ArrayList<SearchResult>(); // 結果の初期化
		for (Map<String, Object> one : list) {
			SearchResult work = new SearchResult();
			work.setRegistId((int)one.get("REGIST_ID"));
			work.setEmployeeId((String)one.get("EMPLOYEE_ID"));
			work.setStatusId((int)one.get("STATUS_ID"));
			work.setWorkDate((Date)one.get("WORK_DATE"));
			work.setStartTime((Time)one.get("START_TIME"));
			work.setEndTime((Time)one.get("END_TIME"));
			work.setBreakTime((int)one.get("BREAK_TIME"));
			work.setComments((String)one.get("COMMENTS"));
			result.add(work);
			
		}

		return result;
	}

}
