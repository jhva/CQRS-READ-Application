package com.example.readelastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.readelastic.entity.Man;
import com.example.readelastic.service.search.SearchManCondition;

public interface ManRepository extends ElasticsearchRepository<Man, String> {




}
