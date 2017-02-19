package main.asw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void evalAdd() {
        Calculator calc = new Calculator();
        Integer expected = 5;
        assertEquals(calc.add(3, 2), expected);
    }


}
