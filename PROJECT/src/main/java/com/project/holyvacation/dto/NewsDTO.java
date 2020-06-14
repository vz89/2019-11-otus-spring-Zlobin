package com.project.holyvacation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class NewsDTO {
    private String status;
    private int totalResults;
    List<ArticleDTO> articles;

    @Data
    @AllArgsConstructor
    private static class ArticleDTO {
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;
        private String content;
    }
}
