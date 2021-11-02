package com.example.demo.junit.concepto1;
import com.example.demo.service.IRPFCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IRPFCalculatorTest {

    IRPFCalculator calculator = new IRPFCalculator();

    @Test
    void calculateIRPFTest(){

        double result = calculator.calculateIRPF(100);
        assertEquals(21, result);
    }

    @Test
    void calculateIRPFZeroTest(){

        double result = calculator.calculateIRPF(0);
        assertEquals(0, result);
    }

    @Test
    void calculateIRPFNegativeTest(){

        double result = calculator.calculateIRPF(-100);
        assertEquals(-21, result);
    }



}
