package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Search;
import com.example.demo.entity.SearchResult;
import com.example.demo.repository.SearchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
	@Autowired
	private final SearchRepository repository;

	@Override
	public List<SearchResult> searchResult(Search search) {
		
		List<SearchResult> list = repository.search(search);
		
		return list;
	}

}
