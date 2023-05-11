package com.example.readelastic.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.example.readelastic.repository.ManRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableElasticsearchRepositories
@Slf4j
public class ESConfiguration extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        log.info("elasticsearch configuration");
        // http port 와 통신할 주소  주소바꿔줘야하고
        ClientConfiguration configuration = ClientConfiguration.builder()

            .connectedTo("search-elastic-search-uczx3ownbwrizbitzuyg5pkmse.ap-northeast-2.es.amazonaws.com:443")
            .usingSsl()
            .withBasicAuth("auto-ever-master", "Qw12345678!")
            .build();
        return RestClients.create(configuration).rest();
    }

    @Override
    public ElasticsearchOperations elasticsearchOperations(ElasticsearchConverter elasticsearchConverter,
        RestHighLevelClient elasticsearchClient) {
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }

    // @Bean
    // public RestHighLevelClient client() {
    //     return elasticsearchClient();
    // }

}