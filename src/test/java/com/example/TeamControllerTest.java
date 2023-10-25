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
class TeamControllerTest {

    @Inject
    TeamClient client;

    @Test
    void testList() {
        List<TeamDto> teams = client.list();

        assertEquals(10, teams.size());
    }

    @Test
    void testGet() {
        HttpResponse<TeamDto> response = client.get(1L);

        assertEquals(200, response.code());

        TeamDto team = response.body();
        assertNotNull(team);
        assertEquals("Real Madrid (Santiago Bernabéu)", team.description());
    }

    @Client(PATH)
    interface TeamClient extends TeamApi {}

}
