package com.example;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.example.TeamApi.PATH;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class TeamControllerTest {

    @Inject
    TeamClient client;

    @Test
    void testList() {
        Iterable<Team> teams = client.list();

        assertEquals(2, ((Collection<Team>)teams).size());
    }

    @Test
    void testGet() {
        HttpResponse<Team> response = client.get(1L);

        assertEquals(200, response.code());

        Team team = response.body();

        assertEquals("Real Madrid CF", team.name());
    }

    @Client(PATH)
    interface TeamClient extends TeamApi {}

}
