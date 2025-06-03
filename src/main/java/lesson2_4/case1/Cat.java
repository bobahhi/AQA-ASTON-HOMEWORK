package lesson2_4.case1;

public class Cat extends Animal {
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