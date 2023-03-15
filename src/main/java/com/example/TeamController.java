package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;

import static com.example.TeamApi.PATH;

@Controller(PATH)
public class TeamController implements TeamApi {

    private final TeamRepository repository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Team> list() {
        return repository.findAll();
    }

    @Override
    public HttpResponse<Team> get(Long id) {
        return repository
                .findById(id)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }
}
