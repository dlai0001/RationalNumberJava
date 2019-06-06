package com.davidlai.rational;

import junit.framework.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import com.davidlai.rational.RationalNumber;


public class RationalNumberTest extends TestCase {
    // test method to add two values
    public void testConstructor() {
        RationalNumber x = new RationalNumber(2, 5);
        assertEquals(x.getDenominator(), 5);
        assertEquals(x.getNumerator(), 2);

        RationalNumber y = new RationalNumber(2);
        assertEquals(y.getDenominator(), 1);
        assertEquals(y.getNumerator(), 2);
    }

    public void testConstructorThrows() {
        try {
            new RationalNumber(2, 0);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // test pass
        }
    }

    public void testNumberIsSimplified() {
        RationalNumber x = new RationalNumber(2, 6);
        assertEquals(x.getNumerator(), 1);
        assertEquals(x.getDenominator(), 3);        
    }

    public void testAdd() {
        RationalNumber x = new RationalNumber(2, 6);
        RationalNumber y = new RationalNumber(1, 6);
        RationalNumber result = x.add(y);
        
        RationalNumber expected = new RationalNumber(3, 6);
        assertEquals(expected.getFloatValue(), result.getFloatValue());
    }

    public void testSubstract() {
        RationalNumber x = new RationalNumber(2, 6);
        RationalNumber y = new RationalNumber(1, 6);
        RationalNumber result = x.subtract(y);
        
        RationalNumber expected = new RationalNumber(1, 6);
        assertEquals(expected.getFloatValue(), result.getFloatValue());
    }

    public void testMultiple() {
        RationalNumber x = new RationalNumber(2, 6);
        RationalNumber y = new RationalNumber(1, 6);
        RationalNumber result = x.multiply(y);
        
        RationalNumber expected = new RationalNumber(2, 36);
        assertEquals(expected.getFloatValue(), result.getFloatValue());
    }

    public void testDivide() {
        RationalNumber x = new RationalNumber(2, 6);
        RationalNumber y = new RationalNumber(1, 6);
        RationalNumber result = x.divide(y);
        
        RationalNumber expected = new RationalNumber(12, 6);
        assertEquals(expected.getFloatValue(), result.getFloatValue());
    }

    public void testCompares() {
        ArrayList<RationalNumber> rationals = new ArrayList<RationalNumber>();
        rationals.add(new RationalNumber(1));
        rationals.add(new RationalNumber(1,2));
        rationals.add(new RationalNumber(4,2));

        Collections.sort(rationals);

        RationalNumber first = rationals.get(0);
        RationalNumber second = rationals.get(1);
        RationalNumber third = rationals.get(2);

        assertEquals(first.getFloatValue(), (new RationalNumber(1, 2)).getFloatValue());
        assertEquals(second.getFloatValue(), (new RationalNumber(1)).getFloatValue());
        assertEquals(third.getFloatValue(), (new RationalNumber(4, 2)).getFloatValue());
    }

    public void testPrintDecimal() {
        PrintStream out = mock(PrintStream.class);
        RationalNumber x = new RationalNumber(1, 2, out);

        x.printDecimal();

        verify(out).println("0.5");
    }

    public void testPrintFraction() {
        PrintStream out = mock(PrintStream.class);
        RationalNumber x = new RationalNumber(1, 2, out);

        x.printFraction();

        verify(out).println("1/2");
    }
}