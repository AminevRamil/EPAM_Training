package com.epam.aminev.structural.decorator;


/**
 * The {@code ComplexNumber} class is DeCoRaTe working with
 * complex numbers written in the form "a+ib", where "a" is real part, "b"
 * is imaginary part, and "i" is imaginary unit
 *
 * @author Aminev Ramil
 */

public class ComplexNumber {
    // ISO 31-11
    // Re and Im
    private double re;
    private double im;

    /**
     * Construct default ComplexNumber with zeros
     */
    public ComplexNumber() {
        this.re = 0;
        this.im = 0;
    }

    /**
     * Construct real number in complex form
     *
     * @param re real part
     */
    public ComplexNumber(double re) {
        this.re = re;
        this.im = 0;
    }

    /**
     * Construct complex number with real and imaginary parts
     * Can be used to construct
     *
     * @param re is real part
     * @param im is imaginary part
     */
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * @return absolute value of complex number
     */
    public double abs() {
        return Math.pow(re * re + im * im, 0.5);
    }

    /**
     * Perform addition of two complex numbers
     *
     * @param that complex number to add
     * @return sum of complex numbers
     */
    public ComplexNumber add(ComplexNumber that) {
        return new ComplexNumber(this.re + that.re, this.im + that.im);
    }

    /**
     * Perform subtraction of two complex numbers
     *
     * @param that complex number to subtract
     * @return difference of two numbers
     */
    public ComplexNumber subtract(ComplexNumber that) {
        return new ComplexNumber(this.re - that.re, this.im - that.im);
    }

    /**
     * Perform multiplication of two complex numbers
     *
     * @param that complex number to multiply
     * @return production of two numbers
     */
    public ComplexNumber multiplication(ComplexNumber that) {
        double newRe = this.re * that.re - this.im * that.im;
        double newIm = this.im * that.re + this.re * that.im;
        return new ComplexNumber(newRe, newIm);
    }

    /**
     * Perform division of two complex number
     *
     * @param that divisor
     * @return quotient of two numbers
     */
    public ComplexNumber divide(ComplexNumber that) {
        double a = this.re;
        double b = this.im;
        double c = that.re;
        double d = that.re;

        double newRe = (a * c + b * d) / (c * c + d * d);
        double newIm = (b * c - a * d) / (c * c + d * d);
        return new ComplexNumber(newRe, newIm);
    }

    @Override
    public String toString() {
        return String.format("%.2f%+.2fi", re, im);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }
}
