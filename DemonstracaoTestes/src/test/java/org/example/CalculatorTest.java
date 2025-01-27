package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator cl;

    @BeforeEach
    public void setUp(){
        cl = new Calculator();
    }

    @Test
    public void testAddPositive() {
        assertEquals(10, cl.add(8, 2));
        assertEquals(20, cl.add(15, 5));
    }

    @Test
    public void testAddZero(){
        assertEquals(0,cl.add(0,0));
        assertEquals(0,cl.add(5,-5));
        assertEquals(10,cl.add(0,10));
    }

    @Test
    public void testAddNegative(){
        assertEquals(-100,cl.add(-80,-20));
        assertEquals(-6,cl.add(-3,-3));
    }

    @Test
    public void testAddPositiveNegative(){
        assertEquals(-5,cl.add(10,-15));
        assertEquals(15,cl.add(-1,16));
    }

    @Test
    public void testDividePositive(){
        assertEquals(10,cl.divide(100,10));
        assertEquals(4,cl.divide(8,2));
    }

    @Test
    public void testDivideNegative(){
        assertEquals(-5,cl.divide(-50,10));
        assertEquals(-100,cl.divide(-200,2));
    }

    @Test
    public void testDivideByZero(){
        assertThrows(IllegalArgumentException.class, () -> cl.divide(10,0));
    }
}