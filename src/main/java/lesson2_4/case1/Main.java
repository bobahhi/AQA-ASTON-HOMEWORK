package lesson2_4.case1;

public class Main {
    public static void main(String[] args) {
        Dog dogReks = new Dog("Рекс");
        Cat catMurka = new Cat("Муся");

        dogReks.run(150);
        catMurka.run(210);

        dogReks.swim(5);
        catMurka.swim(1);

        System.out.println("Всего животных: " + Animal.getTotalAnimals());
        System.out.println("Котов: " + Cat.getCatsCount());
        System.out.println("Собак: " + Dog.getDogsCount());

        // Коты и миска
        Cat[] cats = {
                new Cat("Толстый"),
                new Cat("Рыжий"),
                new Cat("Марс")
        };
        Bowl bowl = new Bowl(20);

        for (Cat cat : cats) {
            cat.eat(bowl, 10); // каждый кот хочет по 10
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт(а): " + cat.isSatiety());
        }

        bowl.addFood(15);
        cats[1].eat(bowl, 10);
        System.out.println(cats[1].getName() + " сыт(а): " + cats[1].isSatiety());
    }
}