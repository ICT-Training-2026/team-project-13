package com.example.demo.repository;

import java.sql.Date;
import java.sql.Time;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchCsvResult;
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
	
	@Override
	public List<SearchCsvResult> searchCsv(Search search) {
		String sql =" SELECT  "
				+ "    employee_id AS 社員コード, "
				+ "    DATE_FORMAT(work_date, '%Y-%m') AS 年月,  "
				+ "    HOUR(start_time) AS 始業時刻_時,  "
				+ "    MINUTE(start_time) AS 始業時刻_分,  "
				+ "    HOUR(end_time) AS 就業時刻_時,  "
				+ "    MINUTE(end_time) AS 就業時刻_分,  "
				+ "    TIMESTAMPDIFF(MINUTE, start_time, end_time) / 60- break_time / 60 AS 労働時間_時,  "
				+ "    break_time / 60 AS 休憩時間_時,  "
				+ "    GREATEST(0, TIMESTAMPDIFF(MINUTE, start_time, end_time) / 60 - break_time / 60 - 7) AS 超過時間_時  "
				+ " FROM   "
				+ "    attendance_info  "
				+ " WHERE  "
				+ "    DATE_FORMAT(WORK_DATE, '%Y-%m') = ? "
				+ "    AND employee_id=?; ";
		

		List<Map<String, Object>> list 
		= jdbcTemplate.queryForList(sql, search.getYearMonth(),search.getUserId());
		
		System.out.println(list);
		
		List<SearchCsvResult> result = new ArrayList<SearchCsvResult>(); // 結果の初期化
	    for (Map<String, Object> one : list) {
	        SearchCsvResult csv = new SearchCsvResult();

	        // 社員コードをString型として取得
	        String employeeId = (String) one.get("社員コード");
	        if (employeeId != null) {
	            csv.setEmployeeId(employeeId);
	        } else {
	            // nullの場合の処理（例: デフォルト値を設定する）
	            csv.setEmployeeId(""); // デフォルト値として空文字を設定する例
	        }

	        // 年月をYearMonth型に変換
	        String yearMonthStr = (String) one.get("年月");
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
	        YearMonth yearMonth = YearMonth.parse(yearMonthStr, formatter);
	        csv.setYearMonth(yearMonth);

	        // 時刻関連のフィールドをint型にキャスト
	        csv.setStartHour(((Number) one.get("始業時刻_時")).intValue());
	        csv.setStartMinute(((Number) one.get("始業時刻_分")).intValue());
	        csv.setEndHour(((Number) one.get("就業時刻_時")).intValue());
	        csv.setEndMinute(((Number) one.get("就業時刻_分")).intValue());

	        // 労働時間、休憩時間、超過時間をdouble型に変換
	        csv.setWorkTime(((Number) one.get("労働時間_時")).doubleValue());
	        csv.setBreakTime(((Number) one.get("休憩時間_時")).doubleValue());
	        csv.setOverTime(((Number) one.get("超過時間_時")).doubleValue());

	        result.add(csv);
	    }

	    return result;
	}


}