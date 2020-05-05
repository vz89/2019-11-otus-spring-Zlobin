package com.project.holyvacation.client;

import com.project.holyvacation.dto.NewsDTO;

public interface NewsRestClient {

    NewsDTO getAllNewsByIso(String iso);
}
