package com.example;

import io.micronaut.context.annotation.Mapper.Mapping;
import jakarta.inject.Singleton;

@Singleton
public interface TeamMapper {

    @Mapping(to = "description", from = "#{this.getDescription(team)}")
    TeamDto toDto(Team team);

    default String getDescription(Team team) {
        return String.format("%s (%s)", team.name(), team.stadium());
    }
}
