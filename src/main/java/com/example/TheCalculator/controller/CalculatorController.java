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
        return calculatorService.getCalculatorSolution(input);
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping("/xml")
    public double writeXml(@RequestBody String file) throws IOException {
        return calculatorService.writeInXml(new File(file));
    }
}
