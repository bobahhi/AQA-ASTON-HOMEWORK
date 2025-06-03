package lesson2_4.case1;

public class Dog extends Animal {
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