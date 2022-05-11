package com.example;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

@Singleton
public class Bootstrap implements ApplicationEventListener<ServerStartupEvent> {

    private final TeamRepository repository;

    public Bootstrap(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        repository.save(new Team("Real Madrid CF", "Santiago Bernabeu"));
        repository.save(new Team("FC Barcelona", "Camp Nou"));
    }

}
