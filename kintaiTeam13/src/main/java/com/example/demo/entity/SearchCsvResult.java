package com.example.demo.entity;

import java.time.YearMonth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCsvResult {
	
	private String employeeId;
    private YearMonth yearMonth;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private double workTime;
    private double breakTime;
    private double overTime;

    
}