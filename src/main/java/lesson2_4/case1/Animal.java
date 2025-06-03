package lesson2_4.case1;

public class Animal {
    protected String name;
    protected static int totalAnimals = 0;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал(а) " + distance + " метров");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл(а) " + distance + " метров");
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public String getName() {
        return name;
    }
}