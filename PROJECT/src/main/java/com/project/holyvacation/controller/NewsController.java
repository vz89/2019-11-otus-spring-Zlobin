package com.project.holyvacation.controller;

import com.project.holyvacation.dto.NewsDTO;
import com.project.holyvacation.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news/{iso}")
    public ResponseEntity<NewsDTO> findNews(@PathVariable("iso") String iso) {
        NewsDTO newsDTO = newsService.findAllNewsByIso(iso);
        return newsDTO != null
                ? new ResponseEntity<>(newsDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
