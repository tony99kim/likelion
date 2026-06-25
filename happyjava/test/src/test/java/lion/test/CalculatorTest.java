package lion.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import test.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int i = calc.add(1,2);
        assertEquals(3, i);

    }

}
