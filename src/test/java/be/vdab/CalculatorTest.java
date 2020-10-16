package be.vdab;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    //Unit test isEven(): parameterized test, input value source
    @ParameterizedTest(name = "Test isEven()")
    @ValueSource(ints = {1,2,3,4,5,6})
    public void isEven(int number) {
        Calculator calculator = new Calculator();
        assertTrue(calculator.isEven(number),number + " is not even");
    }

    //Unit tests of method add() from class Calculator
    @Test
    @DisplayName("addTwoNumbers")
    public void addTwoNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1,1);
        assertEquals(2,result,"1+1 should equal 2");
        //assertFalse(result == 2, "False");
        //assertNotEquals(2,result,"should not unequal 2");
    }
    @ParameterizedTest(name = "{0} + {1} + {2} = {3}")
    @CsvSource({"1,1,1,3","1,2,3,6"})
    public void addThreeNumbers(int first, int second, int third, int expectedResult) {
        Calculator calculator = new Calculator();;
        assertEquals(expectedResult,calculator.add(first,second,third),
                first + " + " + second + " + " + third + " doesn't equal " + expectedResult);
    }

}
