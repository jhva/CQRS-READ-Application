package com.example.readelastic.service.search;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchManCondition {
    private Integer age;

    private Integer height;
    private String name;
    private String hobby;

    private String githubUrl;

}
