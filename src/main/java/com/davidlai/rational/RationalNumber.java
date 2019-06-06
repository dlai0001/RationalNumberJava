package com.davidlai.rational;
import java.io.PrintStream;


public class RationalNumber implements Comparable<RationalNumber> {
    protected int numerator;
    protected int denominator;
    private PrintStream ioStream = System.out;

    /**
     * Creates a rational number using a whole number.
     * @param wholeNumber
     */
    public RationalNumber(int wholeNumber) {
        this(wholeNumber, 1);
    }

    /**
     * Creates a rational number using faractional parts.
     * @param numerator
     * @param denominator
     */
    public RationalNumber(int numerator, int denominator) {
        if (denominator < 1) {
            throw new IllegalArgumentException("Denominator must be integer 1 or greater");
        }

        this.denominator = denominator;
        this.numerator = numerator;

        this.simplify();
    }

    /**
     * Protected constructor for unit testing.
     * @param numerator
     * @param denominator
     * @param ioStream
     */
    protected RationalNumber(int numerator, int denominator, PrintStream ioStream) {
        this(numerator, denominator);
        this.ioStream = ioStream;
    }

    /**
     * Getter for numerator
     * @return
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Getter for denominator
     * @return
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * To String.  Returns basic factional representation.  Ex: 1/4
     */
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(this.numerator);
        } else {
            return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
        }
    }

    /**
     * Prints this number in decimal form.
     */
    public void printDecimal() {
        ioStream.println(Float.toString(this.getFloatValue()));
    }

    /**
     * Prints this number in fractional form.
     */
    public void printFraction() {
        ioStream.println(this.toString());
    }

    /**
     * Adds y to this rational number and returns new rational number as the result.
     * @param y
     * @return
     */
    public RationalNumber add(RationalNumber y) {
        int newNumerator = (this.numerator * y.denominator) + (y.numerator * this.denominator);
        int newDenominator = this.denominator * y.denominator;

        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Subtracts y to this rational number, and returns new rational number as the result.
     * @param y
     * @return
     */
    public RationalNumber subtract(RationalNumber y) {
        int newNumerator = (this.numerator * y.denominator) - (y.numerator * this.denominator);
        int newDenominator = this.denominator * y.denominator;

        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Multiplies this rational number by X.  Returns new rational number as result.
     * @param y
     * @return
     */
    public RationalNumber multiply(RationalNumber y) {
        int newNumerator = this.numerator * y.numerator;
        int newDenominator = this.denominator * y.denominator;

        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Divides this rational number by y, returns new rational number as result.
     * @param y
     * @return
     */
    public RationalNumber divide(RationalNumber y) {
        int newNumerator = this.numerator * y.denominator;
        int newDenominator = this.denominator * y.numerator;

        return new RationalNumber(newNumerator, newDenominator);
    }

    /**
     * Gets float value of this rational number.
     * @return
     */
    public float getFloatValue() {
        return (float) this.numerator / (float) this.denominator;
    }

    /**
     * Implementation compareTo interface.
     */
    public int compareTo(RationalNumber y) {
        float xValue = (float) this.numerator / (float) this.denominator;
        float yValue = (float) y.numerator / (float) y.denominator;

        if (xValue < yValue) {
            return -1;
        } else if (xValue > yValue) {
            return 1;
        }
        return 0;
    }

    /**
     * Simplifies this rational number expression.
     */
    private void simplify() {
        int gcd = this.greatestCommonDenominator();
        this.denominator /= gcd;
        this.numerator /= gcd;
    }

    /**
     * Get greatest common denominator for simplification.
     * @return
     */
    private int greatestCommonDenominator() {
        int gcd = 1;
        for (int i = 1; i <= this.denominator; i++) {
            if (this.denominator % i == 0 && this.numerator % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

