package com.project.holyvacation.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class RestClientServiceImpl<T> implements RestClientService<T> {
    @Override
    public T getResponseBody() {
        return null;
    }

    public ResponseEntity getResponseEntity(UriComponentsBuilder builder, HttpEntity<?> entity) {
        return null;
    }

    public UriComponentsBuilder getUriComponentsBuilder(String serverUrl, String iso) {
        return null;
    }

    public HttpHeaders getHttpHeaders(Map<?, ?> headers) {
        return null;
    }
}
