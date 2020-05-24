package com.project.holyvacation.service;

import com.project.holyvacation.client.NewsRestClient;
import com.project.holyvacation.dto.NewsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRestClient newsRestClient;

    @Override
    public NewsDTO findAllNewsByIso(String iso) {
        return newsRestClient.getAllNewsByIso(iso);
    }
}
