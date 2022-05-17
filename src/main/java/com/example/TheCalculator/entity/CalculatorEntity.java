package com.example.TheCalculator.entity;

public class CalculatorEntity {

    private String input;

    private Double solution;


    public CalculatorEntity(){}

    public CalculatorEntity(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Double getSolution() {
        return solution;
    }

    public void setSolution(Double solution) {
        this.solution = solution;
    }
}
