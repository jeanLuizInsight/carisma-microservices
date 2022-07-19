package com.zanatta.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * Configuração realizada via application.yml
 */
//@Configuration
public class ApiGatewayConfiguration {
    
    /**
     * Configurando as rotas
     * @param builder
     * @return
    */
    //@Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
            // rota para o cambio service
            .route(fn -> fn.path("/cambio-service/**")
                // direciona para o load balancer do eureka (naming-server)
                .uri("lb://cambio-service"))
            // rota para o book service
            .route(fn -> fn.path("/book-service/**")
                // direciona para o load balancer do eureka (naming-server)
                // dessa forma API Gateway conversa com o Service registry pra balancear
                .uri("lb://book-service"))
            .build();
    }
}
