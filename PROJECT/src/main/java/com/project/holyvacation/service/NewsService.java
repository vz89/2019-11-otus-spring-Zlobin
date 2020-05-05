package com.project.holyvacation.service;

import com.project.holyvacation.dto.ArticleDTO;
import com.project.holyvacation.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    NewsDTO findAllNewsByIso(String iso);
}
