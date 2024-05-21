package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

public interface TeamApi {

    String PATH = "/teams";

    @Get
    List<TeamDto> list();

    @Get("/{id}")
    HttpResponse<TeamDto> get(Long id);

    @Post
    HttpResponse<TeamDto> save(TeamDto teamDto);
}
