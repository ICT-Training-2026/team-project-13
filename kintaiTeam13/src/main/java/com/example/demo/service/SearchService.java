package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchResult;

public interface SearchService {

	List<SearchResult> searchResult(Search search);
}
