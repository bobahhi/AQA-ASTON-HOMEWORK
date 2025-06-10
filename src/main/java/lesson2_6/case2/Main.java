package lesson2_6.case2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "111-111-111");
        phoneBook.add("Иванов", "222-222-222");
        phoneBook.add("Петров", "333-333-333");
        phoneBook.add("Васильев", "444-444-444");
        phoneBook.add("Федоров", "555-555-555");

        System.out.println("Телефоны Иванова:");
        for (String phone : phoneBook.get("Иванов")) {
            System.out.println(phone);
        }


        System.out.println("\nСправочник:");
        phoneBook.printAll();
    }
}
