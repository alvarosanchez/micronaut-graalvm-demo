package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.Sql;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.example.TeamApi.PATH;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
@Sql({"classpath:create.sql", "classpath:data.sql"})
@Sql(scripts = "classpath:clean.sql", phase = Sql.Phase.AFTER_ALL)
class TeamControllerTest {

    @Inject
    TeamClient client;

    @Test
    void testList() {
        List<TeamDto> teams = client.list();

        assertFalse(teams.isEmpty());
    }

    @Test
    void testGet() {
        HttpResponse<TeamDto> response = client.get(1L);

        assertEquals(200, response.code());

        TeamDto team = response.body();
        assertNotNull(team);
        assertEquals("Real Madrid (Santiago Bernabéu)", team.description());
    }

    @Test
    void testSave() {
        TeamDto team = TeamDtoBuilder.builder()
                        .description("Wisła Kraków (Stadion Miejski)")
                        .build();

        HttpResponse<TeamDto> response = client.save(team);

        assertEquals(201, response.code());
        assertNotEquals(-1L, client.get(response.body().id()));
    }

    @Client(PATH)
    interface TeamClient extends TeamApi {}

}
