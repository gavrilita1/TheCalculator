package com.example.TheCalculator.service;

import com.example.TheCalculator.Algoritm;
import com.example.TheCalculator.entity.CalculatorEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class CalculatorService {


    private String input;

    public Double getCalculatorSolution(String input) {
        assert (!input.isBlank() && input.charAt(0)>0 && input != null):  "input is invaid";
        CalculatorEntity calculator = new CalculatorEntity(input);
        calculator.setSolution(Algoritm.generateSolutionWithoutSteps(input));
        Double result = calculator.getSolution();
        assert (!result.equals(null)):  "Value of " + result + " is null ";
        return result;
    }

    public double writeInXml(File file){
        assert (file.exists() && file.canRead()):  "file is invaid";
        try {
            ObjectMapper mapper = new XmlMapper();
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<CalculatorEntity>> typeReference = new TypeReference<>() {};

            List<CalculatorEntity> calculators= mapper.readValue(inputStream, typeReference);
            for(CalculatorEntity c :calculators) {
                System.out.println("The input is "+c.getInput());
                this.input=c.getInput();
            }
            Double result = Algoritm.generateSolutionWithoutSteps(input);
            assert (!result.equals(null)):  "result is invaid";
            return result;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

