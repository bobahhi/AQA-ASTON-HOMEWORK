package Lesson2_7;

import java.math.BigInteger;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        return a / b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public BigInteger getFactorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int index = 1; index <= num; index++)
            result = result.multiply(BigInteger.valueOf(index));
        return result;
    }

    public int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public double triangleArea(double bottomSide, double height) {
        return 0.5 * bottomSide * height;
    }


}
