package lesson2_4.case2;

public class Circle implements Shape {
    private final double radius;
    private final String fillColor;
    private final String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String fillColor() {
        return fillColor;
    }

    @Override
    public String borderColor() {
        return borderColor;
    }
}