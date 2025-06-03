package lesson2_4.case2;

public interface Shape {
    double perimeter();
    double area();
    String fillColor();
    String borderColor();

    default void printInfo() {
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет заливки: " + fillColor());
        System.out.println("Цвет границы: " + borderColor());
    }
}