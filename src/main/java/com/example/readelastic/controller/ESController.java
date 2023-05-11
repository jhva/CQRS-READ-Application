package com.example.readelastic.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.readelastic.entity.Man;
import com.example.readelastic.service.EsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ESController {

    private final EsService esService;

    @GetMapping("/search/man")
    public ResponseEntity<List<Man>> searchManByMessage(@RequestParam(required = false) String githubUrl,
        @RequestParam(required = false) String hobby, @RequestParam(required = false) Integer height,
        @RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        List<Man> result = esService.getMan(hobby, githubUrl, height, name, age);

        log.info("result = {}", result);
        return ResponseEntity.ok(result);
    }
}
