package be.vdab.TutorialUdemyTests;

import be.vdab.TutorialUdemy.ValidateISBN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

    @Test
    void checkISBN_10DigitValidISBN_BooleanTrue() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0143039954");
        assertTrue(result);
    }

    @Test
    void checkISBN_13DigitValidISBN_BooleanTrue() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260087");
        assertTrue(result);
    }

    @Test
    void checkISBN_10DigitInvalidISBN_BooleanFalse() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0143039955");
        assertFalse(result);
    }

    @Test
    void checkISBN_13DigitInvalidISBN_BooleanFalse() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781853260086");
        assertFalse(result);
    }

    @Test
    void checkISBN_WrongNumberOfDigitsISBN_NumberFormatException() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(
                NumberFormatException.class,
                ()->{validator.checkISBN("014303995");}
        );
    }

    @Test
    void checkISBN_10DigitISBNNotNumericInput_NumberFormatException() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(
                NumberFormatException.class,
                ()->{validator.checkISBN("HelloWorld");}
        );
    }

    @Test
    void checkISBN_10DigitValidISBNEndingInX_BooleanTrue() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("788721470X");
        assertTrue(result);
    }



}
