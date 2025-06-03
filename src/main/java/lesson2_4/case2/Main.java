package lesson2_4.case2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(10, "Белый", "Черный"),
                new Rectangle(5, 8, "Красный", "Желтый"),
                new Triangle(5, 6, 7, "Зеленый", "Синий")
        };

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName());
            shape.printInfo();
            System.out.println();
        }
    }
}