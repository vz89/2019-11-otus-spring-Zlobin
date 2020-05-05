package com.project.holyvacation.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewsDTO {
    private String status;
    private int totalResults;
    List<ArticleDTO> articles;
}
