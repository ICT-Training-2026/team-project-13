package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchCsvResult;
import com.example.demo.service.SearchService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class CsvController {
	
	@Autowired
    private final SearchService searchService;
	
	 @PostMapping("/csv-export")
	 public String searchCsvExport(@RequestParam String id,@RequestParam String yearMonth, Model model) {
		
//		 System.out.println(id);
//		 System.out.println(yearMonth);
//		 model.addAttribute("id", id);
//		 model.addAttribute("yearMonth", yearMonth);
		 Search search = new Search(id,yearMonth);
		 System.out.println(search);
		  
		 List<SearchCsvResult> list = searchService.searchCsvResult(search);
//		 System.out.println(list);
		
		 model.addAttribute("searchCsvResult", list);
		
		 return "csv_export";
	 }
}