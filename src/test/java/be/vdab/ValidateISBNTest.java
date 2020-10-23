package be.vdab;

import be.vdab.ValidateISBN;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

    ValidateISBN validator;

    @BeforeEach
    void setup() {
        validator = new ValidateISBN();
    }

//    What should the logic be?
//    valid 10 digit isbn
//    valid 13 digit isbn

    @Test
    void checkISBN_10DigitValidISBN_BooleanTrue() {
        boolean result = validator.checkISBN("0143039954");
        assertTrue(result);
    }

    @Test
    void checkISBN_13DigitValidISBN_BooleanTrue() {
        boolean result = validator.checkISBN("9781853260087");
        assertTrue(result);
    }

//    What is the opposite of that logic?
//    invalid 10 digit isbn, only numbers
//    invalid 13 digit isbn, only numbers

    @Test
    void checkISBN_10DigitInvalidISBNOnlyNumbers_BooleanFalse() {
        boolean result = validator.checkISBN("0143039955");
        assertFalse(result);
    }

    @Test
    void checkISBN_13DigitInvalidISBNOnlyNumbers_BooleanFalse() {
        boolean result = validator.checkISBN("9781853260086");
        assertFalse(result);
    }

//    Are there any edge cases?
//    valid 10 digit isbn with X
//    invalid 10 digit isbn with X

    @Test
    void checkISBN_10DigitValidISBNEndingInX_BooleanTrue() {
        boolean result = validator.checkISBN("788721470X");
        assertTrue(result);
    }

    @Test
    void checkISBN_10DigitInvalidISBNEndingInX_BooleanTrue() {
        boolean result = validator.checkISBN("788721770X");
        assertFalse(result);
    }

//    Are there any error conditions?
//    invalid 10 digit isbn not numeric
//    invalid 13 digit isbn not numeric
//    isbn with length not 10 or 13

    @Test
    void checkISBN_10DigitISBNNotNumericInput_NumberFormatException() {
        assertThrows(
                NumberFormatException.class,
                ()->{validator.checkISBN("HelloWorld");}
        );
    }

    @Test
    void checkISBN_13DigitISBNNotNumericInput_NumberFormatException() {
        assertThrows(
                NumberFormatException.class,
                ()->{validator.checkISBN("HelloWorld123");}
        );
    }

    @Test
    void checkISBN_WrongNumberOfDigitsISBN_NumberFormatException() {
        assertThrows(
                NumberFormatException.class,
                ()->{validator.checkISBN("014303995");}
        );
    }

}
