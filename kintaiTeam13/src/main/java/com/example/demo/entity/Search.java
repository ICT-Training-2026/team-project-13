package com.example.demo.entity;

import java.time.YearMonth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Search {
	
	private String userId;
	private YearMonth yearMonth;

}

