package com.example.readelastic.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ManResponse {

    private Long id;

    private String name;

    private int age;

    private String hobby;

    private int height;

    private String job;

    private String tech;

    private String githubUrl;
}
