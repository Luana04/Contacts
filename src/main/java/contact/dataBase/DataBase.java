package contact.dataBase;

import com.github.javafaker.Faker;

import java.util.*;

public class DataBase {

    static Random rnd = new Random();

    public static Set<Contact> getDataBase() {
        Faker faker = new Faker();
        Set<Contact> contacts = new HashSet<>();
        int phone;
        StringBuilder phoneString;
        boolean isInvalid;

        for (int i = 0; i < 33; i++) {
            isInvalid = true;
            phoneString = new StringBuilder("07");
            Contact contact = new Contact("A", "B", "C", "D");
            contact.setFullName(faker.funnyName().name());
            contact.setEmail("fakerDoesNotHave@anyMail.com");
            contact.setAddress(faker.address().cityName() + ", " + faker.address().streetName() + " " + faker.address().buildingNumber());
            do {
                phone = rnd.nextInt(99999999);
                if (phone > 10000000){
                    phoneString.append(phone);
                    if (phoneString.toString().toCharArray().length == 10){
                        isInvalid = false;
                    }
                }
            }
            while (isInvalid);

            phoneString = new StringBuilder(diviseDigits(phoneString.toString()));
            contact.setPhoneNumber(phoneString.toString());

            contacts.add(contact);
        }

        return contacts;
    }

    public static void printDataBase(Set<Contact> contacts) {
        int i = 1;

        for (Contact contact : contacts) {
            if (i < 10){
                System.out.print("|   " + i + ". ");
            }
            else {
                System.out.print("|  " + i + ". ");
            }
            printPhoneNumber(contact, getTheBiggestName(contacts));
            System.out.print(" ---------        " + contact.getPhoneNumber());
            System.out.println();
            i++;
        }

    }

    public static void printPhoneNumber(Contact contact, int maxLetters){
        if (contact.getFullName().toCharArray().length < maxLetters){
            while (contact.getFullName().toCharArray().length < maxLetters){
                contact.setFullName(contact.getFullName() + " ");
            }
        }
        System.out.print(contact.getFullName() + "   ");
    }

    public static String diviseDigits(String number){
        StringBuilder newNumber = new StringBuilder();
        List<Character> digits = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            digits.add(number.charAt(i));
        }

        digits.add(' ');

        for (int i = 4; i < 7; i++) {
            digits.add(number.charAt(i));
        }

        digits.add(' ');

        for (int i = 7; i < 10; i++) {
            digits.add(number.charAt(i));
        }


        for (Character digit : digits) {
            newNumber.append(digit);
        }

        return newNumber.toString();
    }


    public static int getTheBiggestName(Set<Contact> contacts){
        int maxLetters = 0;
        Contact contact;
        Iterator<Contact> iterator = contacts.iterator();
        List<Contact> contactList = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            contact = iterator.next();
            contactList.add(contact);
        }

        for (Contact value : contactList) {
            contact = value;
            if (contact.getFullName().toCharArray().length > maxLetters) {
                maxLetters = contact.getFullName().toCharArray().length;
            }
        }

        return maxLetters;
    }
}

