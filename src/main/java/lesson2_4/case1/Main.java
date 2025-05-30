package lesson2_4.case1;

class Animal {
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
}

class Dog extends Animal {
    private static int dogsCount = 0;
    private static final int maxRun = 500;
    private static final int maxSwim = 10;

    public Dog(String name) {
        super(name);
        dogsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwim) {
            System.out.println(name + " проплыл " + distance + " метров");
        } else {
            System.out.println(name + " не смог проплыть " + distance + " метров");
        }
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}

class Cat extends Animal {
    private static int catsCount = 0;
    private static final int maxRun = 200;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        catsCount++;
        satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.println(name + " пробежал(а) " + distance + " метров");
        } else {
            System.out.println(name + " не смог(ла) пробежать " + distance + " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            satiety = true;
            System.out.println(name + " покушал(а), теперь сыт(а)");
        } else {
            System.out.println(name + " не хватило еды");
        }
    }

    public static int getCatsCount() {
        return catsCount;
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды. В миске: " + food);
        }
    }

    public int getFood() {
        return food;
    }
}

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
            System.out.println(cat.name + " сыт(а): " + cat.isSatiety());
        }

        bowl.addFood(15);
        cats[1].eat(bowl, 10);
        System.out.println(cats[1].name + " сыт(а): " + cats[1].isSatiety());
    }
}