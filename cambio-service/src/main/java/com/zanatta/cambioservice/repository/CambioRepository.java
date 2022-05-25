package com.zanatta.cambioservice.repository;

import com.zanatta.cambioservice.models.Cambio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
    
    Cambio findByFromAndTo(String from, String to);
}
