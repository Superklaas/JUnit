package be.vdab;

import javax.swing.text.Utilities;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        int gcd = greatestCommonDivisor(numerator,denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }

    public static int greatestCommonDivisor (int num1, int num2) {
        int gcd = 0;
        for(int i = 1; i <= num1 && i <= num2; i++) {
            if(num1%i==0 && num2%i==0) {
                gcd = i;
            }
        }
        return gcd;
    }

    @Override
    public String toString() {
        return (numerator + "/" + denominator);
    }
}
