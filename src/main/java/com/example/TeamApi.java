package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;

public interface TeamApi {

    String PATH = "/teams";

    @Get
    Iterable<Team> list();

    @Get("/{id}")
    HttpResponse<Team> get(Long id);
}
