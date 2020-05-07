package com.project.holyvacation.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public interface RestClientService<T> {

    T getResponseBody();

    ResponseEntity getResponseEntity(UriComponentsBuilder builder, HttpEntity<?> entity);

    UriComponentsBuilder getUriComponentsBuilder(String serverUrl, String iso);

    HttpHeaders getHttpHeaders(Map<?,?> headers);
}
