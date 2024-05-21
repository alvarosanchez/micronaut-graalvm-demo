package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;

import java.net.URI;
import java.util.List;

import static com.example.TeamApi.PATH;

@Controller(PATH)
public class TeamController implements TeamApi {

    private final TeamRepository repository;
    private final TeamMapper mapper;

    public TeamController(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TeamDto> list() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public HttpResponse<TeamDto> get(Long id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .map(HttpResponse::ok)
                .orElse(HttpResponse.notFound());
    }

    @Override
    public HttpResponse<TeamDto> save(TeamDto teamDto) {
        Team saved = repository.save(mapper.toEntity(teamDto));
        return HttpResponse.created(URI.create(PATH + "/" + saved.id()))
                .body(mapper.toDto(saved));
    }
}
