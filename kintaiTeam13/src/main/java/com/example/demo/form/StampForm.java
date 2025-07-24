package com.example.demo.form;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StampForm {
	
	  private int registId;
	    private String employeeId;
	    private int statusId;
	    private Date workDate;
	    private Time startTime;
	    private Time endTime;
	    private int breakTime;
	    private String comments;

}
