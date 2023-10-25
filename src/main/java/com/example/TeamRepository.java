package com.example;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {}

@JdbcRepository(dialect = Dialect.POSTGRES)
interface PostgresTeamRepository extends TeamRepository {}
