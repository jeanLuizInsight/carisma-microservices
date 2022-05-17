package com.zanatta.calculator.service;

import com.zanatta.calculator.exception.MathException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double somar(String n1, String n2) {
        return this.converterStringParaNumerico(n1) + this.converterStringParaNumerico(n2);
    }

    public Double subtrair(String n1, String n2) {
        return this.converterStringParaNumerico(n1) - this.converterStringParaNumerico(n2);
    }

    public Double multiplicar(String n1, String n2) {
        return this.converterStringParaNumerico(n1) * this.converterStringParaNumerico(n2);
    }

    public Double dividir(String n1, String n2) {
        return this.converterStringParaNumerico(n1) / this.converterStringParaNumerico(n2);
    }

    public Double calcularMedia(String n1, String n2) {
        return (this.converterStringParaNumerico(n1) + this.converterStringParaNumerico(n2)) / 2;
    }

    public Double calcularRaiz(String n) {
        return Math.sqrt(this.converterStringParaNumerico(n));
    }
    
    private Double converterStringParaNumerico(String number) {
        if (number == null || "".equals(number)) {
            throw new MathException("É obrigatório informar números no path variable!");
        }
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new MathException("Número inválido!");
        }
        number = number.replaceAll(",", ".");
        return Double.parseDouble(number);
    }
}
