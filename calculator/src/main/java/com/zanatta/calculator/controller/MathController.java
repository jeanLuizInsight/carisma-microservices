package com.zanatta.calculator.controller;

import com.zanatta.calculator.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired MathService mathService;

    @GetMapping(value="/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String n1, @PathVariable("numberTwo") String n2) {
        return this.mathService.somar(n1, n2);
    }

    @GetMapping(value="/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String n1, @PathVariable("numberTwo") String n2) {
        return this.mathService.subtrair(n1, n2);
    }

    @GetMapping(value="/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable("numberOne") String n1, @PathVariable("numberTwo") String n2) {
        return this.mathService.multiplicar(n1, n2);
    }

    @GetMapping(value="/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable("numberOne") String n1, @PathVariable("numberTwo") String n2) {
        return this.mathService.dividir(n1, n2);
    }

    @GetMapping(value="/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable("numberOne") String n1, @PathVariable("numberTwo") String n2) {
        return this.mathService.calcularMedia(n1, n2);
    }

    @GetMapping(value="/raiz/{number}")
    public Double raiz(@PathVariable("number") String n) {
        return this.mathService.calcularRaiz(n);
    }

    
    
}
