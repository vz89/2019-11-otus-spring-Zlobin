package com.project.holyvacation.service;

import com.project.holyvacation.dto.NewsDTO;

public interface NewsService {
    NewsDTO findAllNewsByIso(String iso);
}
