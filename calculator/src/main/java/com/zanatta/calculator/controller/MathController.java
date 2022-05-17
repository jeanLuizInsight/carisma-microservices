package com.zanatta.calculator.controller;

import com.zanatta.calculator.exception.MathException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping(value="/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String n1, @PathVariable("numberTwo") String n2) {
        return this.convert(n1) + this.convert(n2);
    }

    private Double convert(String number) {
        if (number == null || "".equals(number)) {
            throw new MathException("É obrigatório informar números no path variable!");
        }
        number = number.replaceAll(",", ".");
        if (number.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            throw new MathException("Número inválido!");
        }
        return Double.parseDouble(number);
    }
    
}
