package com.example.readelastic.service;

import static org.elasticsearch.index.query.QueryBuilders.*;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.example.readelastic.entity.Man;
import com.example.readelastic.repository.ManRepository;
import com.example.readelastic.repository.ManSearchQueryRepository;
import com.example.readelastic.service.dto.ManResponse;
import com.example.readelastic.service.search.SearchManCondition;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EsService {

    private final ManSearchQueryRepository manSearchQueryRepository;
    private final ManRepository manRepository;

    private final ElasticsearchOperations elasticsearchOperations;

    public List<Man> getMan(String hobby, String githubUrl, Integer height, String name, Integer age) {
        //
        SearchManCondition searchManCondition = SearchManCondition.builder()
            .hobby(hobby)
            .githubUrl(githubUrl)
            .age(age)
            .height(height)
            .name(name)
            .build();

        return manSearchQueryRepository.test(searchManCondition);

    }

    public void search() {
        NativeSearchQueryBuilder nativeSearchQueryBuilder =
            new NativeSearchQueryBuilder().withQuery(matchQuery("message.name", "황치열"));

    }

    public SearchHits<Man> searchManByMessage(String message) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
            .withQuery(matchQuery("age", message))
            .build();

        return elasticsearchOperations.search(searchQuery, Man.class);
    }


}
