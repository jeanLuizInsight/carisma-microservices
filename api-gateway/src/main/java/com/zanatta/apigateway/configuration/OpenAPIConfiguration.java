package com.zanatta.apigateway.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    @Lazy(false)
    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters configParameters, RouteDefinitionLocator locator) {
        final var definitions = locator.getRouteDefinitions().collectList().block();
        definitions.stream()
                .filter(d -> d.getId().matches(".*-service"))
                .forEach(d -> {
                    final var name = d.getId();
                    configParameters.addGroup(name);
                    GroupedOpenApi.builder()
                            .pathsToMatch("/" + name + "/**")
                            .group(name)
                            .build();
                });

        return new ArrayList<>();
    }

}
