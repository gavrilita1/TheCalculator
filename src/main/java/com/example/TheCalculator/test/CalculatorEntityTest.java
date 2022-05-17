package com.example.TheCalculator.test;

import com.example.TheCalculator.entity.CalculatorEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
public class CalculatorEntityTest {

    @Mock
    CalculatorEntity calculatorEntity;

    @Test
    public void testNotNull() {
        assertNotNull(calculatorEntity);
    }

    @Test
    public void testInput() {
        calculatorEntity = new CalculatorEntity("9+2");
        String input = calculatorEntity.getInput();
        assertNotNull(input);
        assertEquals(input, "9+2");
    }

    @Test
    public void testGetSolution() {
        calculatorEntity = new CalculatorEntity("9+2");
        calculatorEntity.setSolution(11.0);
        Double solution = calculatorEntity.getSolution();
        assertEquals(solution, 11.0);
    }

    @Test
    public void testSetSolution() {
        calculatorEntity = new CalculatorEntity();
        calculatorEntity.setSolution(11.0);
        assertNotNull(calculatorEntity.getSolution());
    }
}
