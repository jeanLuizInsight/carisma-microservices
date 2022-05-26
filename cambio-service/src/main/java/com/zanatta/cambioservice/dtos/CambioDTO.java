package com.zanatta.cambioservice.dtos;

import java.math.BigDecimal;

import com.zanatta.cambioservice.models.Cambio;

public class CambioDTO {
    
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String environment;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }
    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public BigDecimal getConvertedValue() {
        return convertedValue;
    }
    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public static CambioDTO builder(Cambio cambio) {
        CambioDTO dto = new CambioDTO();
        dto.setId(cambio.getId());
        dto.setFrom(cambio.getFrom());
        dto.setTo(cambio.getTo());
        dto.setConvertedValue(cambio.getConvertedValue());
        dto.setEnvironment(cambio.getEnvironment());
        dto.setConversionFactor(cambio.getConversionFactor());
        return dto;
    }
}
