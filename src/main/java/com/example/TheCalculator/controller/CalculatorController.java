package com.example.TheCalculator.controller;

import com.example.TheCalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/calculator/")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @CrossOrigin(origins = {"*"})
    @PostMapping("/web")
    public Double calculate(@RequestBody String input){
        assert (!input.isBlank() && input.charAt(0)>0.0 && input != null):  "input is invaid";
        Double result = calculatorService.getCalculatorSolution(input);
        assert (!result.equals(null)):  "result is invaid";
        return result;
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping("/xml")
    public double writeXml(@RequestBody String file) throws IOException {
        assert (!file.isBlank() && file.charAt(0)>0 && file != null):  "input is invaid";
        Double result = calculatorService.writeInXml(new File(file));
        assert (!result.equals(null)):  "result is invaid";
        return result;
    }
}
