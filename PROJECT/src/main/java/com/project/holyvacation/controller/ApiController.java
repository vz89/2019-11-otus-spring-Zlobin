package com.project.holyvacation.controller;

import com.project.holyvacation.dto.NewsDTO;
import com.project.holyvacation.dto.WeatherDTO;
import com.project.holyvacation.service.NewsService;
import com.project.holyvacation.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
@RequiredArgsConstructor

public class ApiController {

    private final NewsService newsService;
    private final WeatherService weatherService;

    @GetMapping("/api/news/{iso}")
    public ResponseEntity<NewsDTO> findNews(@PathVariable("iso") String iso) {
        NewsDTO newsDTO = newsService.findAllNewsByIso(iso);
        return newsDTO != null
                ? new ResponseEntity<>(newsDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/weather", params = {"lat", "lon"})
    public ResponseEntity<WeatherDTO> getWeather(@RequestParam("lat") double lat, @RequestParam("lon") double lon) {
        WeatherDTO weatherDTO = weatherService.getWeatherByLatLon(lat, lon);
        return weatherDTO != null
                ? new ResponseEntity<>(weatherDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
