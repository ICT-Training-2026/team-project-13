package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchResult;
import com.example.demo.service.SearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {
	
	@Autowired
    private final SearchService searchService;
	
	@PostMapping("/search")
	public String showSearch(@RequestParam String id,@RequestParam String authority, Model model) {
	    model.addAttribute("id", id);
	    model.addAttribute("authority", authority);
	    
	  
	    return "search";
	}
	
	@PostMapping("/search_result")
	public String searchResult(@RequestParam String id,@RequestParam String yearMonth, Model model) {
		System.out.println(yearMonth);
	    model.addAttribute("id", id);
	    model.addAttribute("yearMonth", yearMonth);
	    
	    
//	    YearMonth ym = YearMonth.parse(yearMonth);
	    Search search = new Search(id,yearMonth);
	   
	    List<SearchResult> list = searchService.searchResult(search);
	   
//	    int registId = 1;
//        String employeeId = "111111";
//        int statusId = 1;
//        Date workDate = Date.valueOf("2023-10-15"); // yyyy-MM-dd形式で日付を設定
//        Time startTime = Time.valueOf("09:00:00"); // HH:mm:ss形式で時刻を設定
//        Time endTime = Time.valueOf("17:00:00"); // HH:mm:ss形式で時刻を設定
//        int breakTime = 60; // 休憩時間を分で設定
//        String comments = "通常出勤しました";
//
//        // SearchResultオブジェクトを作成し、データを設定
//        SearchResult searchResult = new SearchResult(
//            registId,
//            employeeId,
//            statusId,
//            workDate,
//            startTime,
//            endTime,
//            breakTime,
//            comments
//        );
//        List<SearchResult> list = new ArrayList<>();
//        list.add(searchResult);
        
        model.addAttribute("searchResult", list);
        
	  
	    return "search_Result";
	}

}
