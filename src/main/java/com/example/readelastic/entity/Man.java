package com.example.readelastic.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "topic-kid")
@Mapping(mappingPath = "classpath:elastic/settings/Man-mappings.json")
@Setting(settingPath = "classpath:elastic/settings/Man-settings.json")
// @Mapping(mappingPath = "resources/elastic/settings/Man-mappings.json")
public class Man {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Text)
    private String hobby;

    @Field(type = FieldType.Integer)
    private Integer height;

    @Field(type = FieldType.Text)
    private String job;

    @Field(type = FieldType.Text)
    private String tech;

    @Field(type = FieldType.Text)
    private String githubUrl;


}
