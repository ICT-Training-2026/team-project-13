package com.example.demo.form;

import java.sql.Date;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AttendanceForm {
	
	private String employeeId;
	
	private Integer statusId;
	
	private Date workDate;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private Integer breakTime;
	
	private String comments;

}
