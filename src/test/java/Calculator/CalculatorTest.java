package Calculator;

import Lesson2_7.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    //Сложение
    @Test
    void add() {
        int result = calculator.add(10, 15);
        Assertions.assertEquals(25, result);
    }

    //Вычетание
    @Test
    void subtraction() {
        int result = calculator.subtraction(15, 10);
        Assertions.assertEquals(5, result);
    }

    //Деление
    @Test
    void division() {
        int result = calculator.division(15, 5);
        Assertions.assertEquals(3, result);
    }

    //Умножение
    @Test
    void multiplication() {
        int result = calculator.multiplication(15, 5);
        Assertions.assertEquals(75, result);
    }

    //Факториал числа
    @Test
    void testGetFactorial() {
        BigInteger actual = calculator.getFactorial(15);
        BigInteger expected = new BigInteger("1307674368000");
        Assertions.assertEquals(expected, actual);
    }

    //Сравнение двух чисел
    @Test
    void testCompareEqual() {
        int a = 10;
        int b = 10;
        int expected = 0;
        int actual = calculator.compare(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCompareLess() {
        int a = 5;
        int b = 10;
        int actual = calculator.compare(a, b);
        Assertions.assertTrue(actual < 0);
    }

    @Test
    void testCompareGreater() {
        int a = 15;
        int b = 10;
        int actual = calculator.compare(a, b);
        Assertions.assertTrue(actual > 0);
    }

    //Площадь треугольника
    @Test
    void testTriangleArea() {
        double bottomSide = 10.0;
        double height = 5.0;
        double expected = 25.0;
        double actual = calculator.triangleArea(bottomSide, height);
        Assertions.assertEquals(expected, actual);
    }


}