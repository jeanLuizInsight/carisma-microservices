package com.zanatta.carismaconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Habilitando configuração cloud server
 */
@SpringBootApplication
@EnableConfigServer
public class CarismaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarismaConfigServerApplication.class, args);
	}

}
