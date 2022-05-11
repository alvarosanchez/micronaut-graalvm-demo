package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/teams")
public class TeamController {

    private final TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @Get
    public Iterable<Team> findAll() {
        return repository.findAll();
    }

    @Get("/{id}")
    public HttpResponse<Team> findOne(Long id) {
        return repository
                .findById(id)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }
}
