package com.example.dev;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.management.endpoint.env.EnvironmentEndpointFilter;
import io.micronaut.management.endpoint.env.EnvironmentFilterSpecification;
import jakarta.inject.Singleton;

@Singleton
@Requires(env = Environment.DEVELOPMENT)
public class AllPlainEnvironmentEndpointFilter implements EnvironmentEndpointFilter {

    @Override
    public void specifyFiltering(@NonNull EnvironmentFilterSpecification specification) {
        specification.legacyMasking();
    }
}
