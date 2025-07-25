package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchCsvResult;
import com.example.demo.entity.SearchResult;

public interface SearchRepository {
	
	List<SearchResult> search(Search search);
	List<SearchCsvResult> searchCsv(Search search);

}