package com.example.TheCalculator.controller;

import com.example.TheCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator/")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/webStep")
    public Double calculateStep(@RequestBody String input){
        return calculatorService.getCalculatorSolution(input);
    }

    @GetMapping("/web")
    public Double calculate(@RequestBody String input){
        return calculatorService.getCalculatorSolutionWithoutStep(input);
    }

}
