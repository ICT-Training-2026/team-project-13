package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attendance;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AttendanceRepositoryImpl implements AttendanceRepository {

	private final JdbcTemplate jdbcTemplate;


	public void add(Attendance attendance) {

		String sql = " INSERT INTO attendance_info " +
				" (employee_id, status_id, work_date, start_time, end_time, break_time, comments) " +
				" VALUES (?, ?, ?, ?, ?, ?, ?) ";

		jdbcTemplate.update(sql, 
				attendance.getEmployeeId(),
				attendance.getStatusId(),
				attendance.getWorkDate(),
				attendance.getStartTime(),
				attendance.getEndTime(),
				attendance.getBreakTime(),
				attendance.getComments());
	}

}
