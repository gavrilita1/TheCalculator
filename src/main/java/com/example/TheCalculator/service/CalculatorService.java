package com.example.TheCalculator.service;

import com.example.TheCalculator.Algoritm;
import com.example.TheCalculator.entity.CalculatorEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public Double getCalculatorSolution(String input) {
        CalculatorEntity calculator = new CalculatorEntity(input);
        calculator.setSolution(Algoritm.generateSolution(input));
        return calculator.getSolution();
    }

    public Double getCalculatorSolutionWithoutStep(String input) {
        CalculatorEntity calculator = new CalculatorEntity(input);
        calculator.setSolution(Algoritm.generateSolutionWithoutSteps(input));
        return calculator.getSolution();
    }

}
