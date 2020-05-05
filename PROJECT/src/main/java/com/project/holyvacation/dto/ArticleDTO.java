package com.project.holyvacation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDTO {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    public String content;
}
