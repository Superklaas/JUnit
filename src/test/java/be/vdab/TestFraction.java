package be.vdab;

import be.vdab.Fraction.Fraction;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestFraction {

    @Test
    public void getNumerator() {
        Fraction fraction = new Fraction(1,2);
        int numerator = fraction.getNumerator(); //code under test (CUT)
        assertEquals(1,numerator); //assertion
    }

    @Test
    public void getDenominator() {
        Fraction fraction = new Fraction(1,2);
        assertEquals(2,fraction.getDenominator());
    }

    @Test
    public void greatestCommonDivisor() {
        int gcd = Fraction.greatestCommonDivisor(2,4);
        assertEquals(2,gcd);
    }

    @Test
    public void simplifyFraction() {
        Fraction fraction = new Fraction(2,4);
        assertTrue(fraction.getNumerator() == 1);
        assertTrue(fraction.getDenominator() == 2);
    }

    @Test
    public void testToString() {
        Fraction fraction = new Fraction(2,4);
        assertEquals("1/2",fraction.toString());
    }
}