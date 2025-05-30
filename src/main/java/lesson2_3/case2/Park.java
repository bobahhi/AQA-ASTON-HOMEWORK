package lesson2_3.case2;

public class Park {
    private final String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private final String name;
        private final String workHours;
        private final double price;

        public Attraction(String name, String workHours, double price) {
            this.name = name;
            this.workHours = workHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("\nНазвание: " + parkName);
            System.out.println("Атракцион: " + name);
            System.out.println("Время работы: " + workHours);
            System.out.println("Стоимость: " + price);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Парк развлечений: Universal");
        Park.Attraction carousel = park.new Attraction("Карусель", "09:00 - 19:00", 100);
        Park.Attraction rollerCoaster = park.new Attraction("Американские горки", "09:00 - 19:00", 200);
        Park.Attraction karting = park.new Attraction("Картинг", "09:00 - 19:00", 300);

        carousel.printInfo();
        rollerCoaster.printInfo();
        karting.printInfo();

    }

}
