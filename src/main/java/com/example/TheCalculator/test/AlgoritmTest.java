package com.example.TheCalculator.test;

import com.example.TheCalculator.Algoritm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AlgoritmTest {


    @Test
    public void testResult()  {
        Double result = Algoritm.generateSolutionWithoutSteps("9+2");
        assertEquals(result, 11.0);
        result = Algoritm.generateSolutionWithoutSteps("((4-2^3+1)*-sqrt(3*3+4*4))/2");
        assertEquals(result, 7.5);
        result = Algoritm.generateSolutionWithoutSteps("123+3*2/(10-8)");
        assertEquals(result, 126.0);
    }

}
