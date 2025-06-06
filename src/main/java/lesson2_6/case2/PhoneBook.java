package lesson2_6.case2;

public class PhoneBook {
    private static class ContactInfo {
        String surname;
        String[] phones;
        ContactInfo next;

        ContactInfo(String surname, String phone) {
            this.surname = surname;
            this.phones = new String[]{phone};
            this.next = null;
        }

        void addPhone(String phone) {
            String[] newPhones = new String[phones.length + 1];
            for (int index = 0; index < phones.length; index++) {
                newPhones[index] = phones[index];
            }
            newPhones[phones.length] = phone;
            phones = newPhones;
        }
    }

    private ContactInfo head;

    public PhoneBook() {
        head = null;
    }

    public void add(String surname, String phone) {
        ContactInfo current = head;
        while (current != null) {
            if (current.surname.equals(surname)) {
                current.addPhone(phone);
                return;
            }
            current = current.next;
        }

        ContactInfo newContactInfo = new ContactInfo(surname, phone);
        newContactInfo.next = head;
        head = newContactInfo;
    }

    public String[] get(String surname) {
        ContactInfo current = head;
        while (current != null) {
            if (current.surname.equals(surname)) {
                return current.phones;
            }
            current = current.next;
        }
        return new String[0];
    }

    public void printAll() {
        ContactInfo current = head;
        while (current != null) {
            System.out.print(current.surname + ": ");
            for (int index = 0; index < current.phones.length; index++) {
                System.out.print(current.phones[index]);
                if (index < current.phones.length - 1) System.out.print(", ");
            }
            System.out.println();
            current = current.next;
        }
    }
}
