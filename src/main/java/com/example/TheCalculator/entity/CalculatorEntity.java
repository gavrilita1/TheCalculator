package com.example.TheCalculator.entity;

public class CalculatorEntity {

    private String input;

    private Double solution;


    public CalculatorEntity(){}

    public CalculatorEntity(String input) {
        assert (!input.isBlank() && input.charAt(0)>0 && input != null):  "input is invaid";
        this.input = input;
    }

    public String getInput()  {
        assert (!input.isBlank() && input.charAt(0)>0 && input != null):  "input is invaid";
        return input;
    }

    public void setInput(String input) {
        assert (!input.isBlank() && input.charAt(0)>0 && input != null):  "input is invaid";
        this.input = input;
    }

    public Double getSolution() {
        assert (!input.isBlank() && input.charAt(0)>0 && input != null):  "input is invaid";
        return solution;
    }

    public void setSolution(Double solution) {
        assert (!input.isBlank() && input.charAt(0)>0 && input != null):  "input is invaid";
        this.solution = solution;
    }
}
