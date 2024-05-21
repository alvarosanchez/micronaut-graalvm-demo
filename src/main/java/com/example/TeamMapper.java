package com.example;

import io.micronaut.context.annotation.Mapper.Mapping;
import jakarta.inject.Singleton;

@Singleton
public interface TeamMapper {

    @Mapping(to = "description", from = "#{ team.name() + ' (' + team.stadium() + ')' }")
    TeamDto toDto(Team team);

    @Mapping(to = "name", from = "#{ this.getName(teamDto) }")
    @Mapping(to = "stadium", from = "#{ this.getStadium(teamDto) }")
    Team toEntity(TeamDto teamDto);

    default String getName(TeamDto dto) {
        return dto.description().split(" \\(")[0];
    }

    default String getStadium(TeamDto dto) {
        return dto.description().split("\\(")[1].replace(")", "");
    }

}
