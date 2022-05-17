package com.example.TheCalculator.test;

import com.example.TheCalculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    CalculatorService calculatorService;

    @Test
    public void testNotNull() {
        assertNotNull(calculatorService);
    }

    @Test
    public void testGetCalculatorSolution() {
        calculatorService = new CalculatorService();
        String input = "9+1";
        Double solution = calculatorService.getCalculatorSolution(input);
        assertNotNull(solution);
        assertEquals(solution, 10.0);
    }

    @Test
    public void testWriteInXml() {
        calculatorService = new CalculatorService();
        String file = "C:\\Users\\Rolland G\\Master\\SEM2\\Calitate\\TheCalculator\\src\\main\\resources\\file.xml";
        Double solution = calculatorService.writeInXml(new File(file));
        assertNotEquals(solution,0);
    }


}
