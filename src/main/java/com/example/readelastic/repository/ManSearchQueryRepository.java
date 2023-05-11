package com.example.readelastic.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.readelastic.entity.Man;
import com.example.readelastic.service.search.SearchManCondition;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Repository
@Slf4j
public class ManSearchQueryRepository {

    private final ElasticsearchOperations operations;

    public List<Man> test(SearchManCondition searchManCondition) {

        //
        CriteriaQuery query = createlikesCriteriaQuery(searchManCondition);

        SearchHits<Man> search = operations.search(query, Man.class);
        System.out.println(search);
        log.info("search ={}", search);

        return search.stream().map(SearchHit::getContent).collect(Collectors.toList());
        // return null;
    }

    private CriteriaQuery createlikesCriteriaQuery(SearchManCondition searchManCondition) {

        CriteriaQuery query = new CriteriaQuery(new Criteria());

        //
        Man man = new Man();
        if (StringUtils.hasText(searchManCondition.getHobby())) {
            query.addCriteria(Criteria.where("hobby").contains(searchManCondition.getHobby()));
        }
        if (StringUtils.hasText(searchManCondition.getGithubUrl())) {
            query.addCriteria(Criteria.where("githubUrl").contains(searchManCondition.getGithubUrl()));
        }
        if (searchManCondition.getAge() > 60) {
            query.addCriteria(Criteria.where("age").is(searchManCondition.getAge()));
        }
        if (searchManCondition.getHeight() > 50) {
            query.addCriteria(Criteria.where("height").is(searchManCondition.getHeight()));
        }
        return query;
    }

}
