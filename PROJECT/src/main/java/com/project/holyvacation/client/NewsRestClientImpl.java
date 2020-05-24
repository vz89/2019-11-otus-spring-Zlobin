package com.project.holyvacation.client;

import com.project.holyvacation.dto.NewsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsRestClientImpl implements NewsRestClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;
    private final String apiKey;

    public NewsRestClientImpl(RestTemplate restTemplate, @Value("${api.news.serverUrl}") String serverUrl, @Value("${api.news.apiKey}") String apiKey) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
        this.apiKey = apiKey;
    }

    @Override
    public NewsDTO getAllNewsByIso(String iso) {
        return restTemplate.getForObject(serverUrl + "?" + "country=" + iso + '&' + "apiKey=" + apiKey, NewsDTO.class);
    }
}
