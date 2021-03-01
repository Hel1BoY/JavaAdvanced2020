package com.example.mock;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @Disabled
    @Test
    void divide() {
        Math math = new Math();

        assertThrows(ArithmeticException.class, ()-> {math.divide(5,0);},"You cannot divide by zero!");
        assertEquals(1, math.divide(6,6),"Divide equal number");
        assertThrows(ArithmeticException.class, ()-> {math.divide(4,3);} , "You use ints not doubles (no reminder)");


        //assertThrows(NullPointerException.class, ()-> {math.sum(0,0);});

    }


}