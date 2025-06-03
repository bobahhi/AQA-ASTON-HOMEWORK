package lesson2_3.case1;

public class Main {
    static class Product {
        private final String name;
        private final String manufactureDate;
        private final String manufacturer;
        private final String country;
        private final double price;
        private final boolean itemReserved;

        public Product(String name, String manufactureDate, String manufacturer,
                       String country, double price, boolean itemReserved) {
            this.name = name;
            this.manufactureDate = manufactureDate;
            this.manufacturer = manufacturer;
            this.country = country;
            this.price = price;
            this.itemReserved = itemReserved;
        }

        public void printInfo() {
            System.out.println("Название: " + name);
            System.out.println("Дата производства: " + manufactureDate);
            System.out.println("Производитель: " + manufacturer);
            System.out.println("Страна происхождения: " + country);
            System.out.println("Цена: " + price);
            System.out.println("Состояние бронирования: " + (itemReserved ? "Забронирован" : "Свободен"));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Product[] productArray = new Product[5];

        productArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productArray[1] = new Product("Apple iPhone 14", "15.01.2025",
                "Apple Inc.", "USA", 6999, false);
        productArray[2] = new Product("Samsung Galaxy A06", "11.11.2011",
                "Samsung Corp.", "Korea", 1111, true);
        productArray[3] = new Product("Samsung Galaxy S24 Ultra", "11.11.2011",
                "Samsung Corp.", "Korea", 1111, false);
        productArray[4] = new Product("Samsung Galaxy S23 Ultra", "11.11.2011",
                "Samsung Corp.", "Korea", 1111, true);

        for (Product product : productArray) {
            product.printInfo();
        }
    }
}
