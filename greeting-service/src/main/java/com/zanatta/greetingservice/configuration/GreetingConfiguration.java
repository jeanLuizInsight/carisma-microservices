package com.zanatta.greetingservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * No arquivo do repositório mapeado em carisma-config-server deve estar com o nome
 * Novas propriedades devem serem adicionadas aqui e também no arquivo
 *
 * @RefreshScope vai pegar as configurações sem precisar parar o serviço. Mas tem que usar o /actuator/refresh
 */
@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;

    public GreetingConfiguration() {
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
