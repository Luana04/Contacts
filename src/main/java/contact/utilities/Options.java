package contact.utilities;

import contact.dataBase.Contact;

import java.util.*;

public class Options {

    static Scanner scn = new Scanner(System.in);

    public static void seeDetails(Set<Contact> contacts) {
        boolean isInputInvalid = true;
        boolean isBooleanTrue = true;
        String input;
        String name;
        int nameLength;
        int intInput;
        Contact contact;
        List<Contact> contactList = new ArrayList<>();
        Iterator<Contact> iterator = contacts.iterator();

        for (int i = 0; i < contacts.size(); i++) {
            contact = iterator.next();
            contactList.add(contact);
        }

        System.out.println("\n|  Enter the index of the contact!");
        System.out.print("|  Your answer: ");

        do {
            input = scn.next();
            if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= contacts.size()){
                isInputInvalid = false;
            }
            else {
                System.out.print("|  Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        intInput = Integer.parseInt(input);


        contact = contactList.get(intInput);
        name = contact.getFullName();
        nameLength = name.length();
        nameLength--;

        while (isBooleanTrue){
            if (contact.getFullName().charAt(nameLength) == ' '){
                name = name.substring(0, name.length() - 1);
                nameLength--;
            }
            else {
                isBooleanTrue = false;
            }
        }

        System.out.println("\n|  Name:          " + name);
        System.out.println("|  Phone Number:  " + contact.getPhoneNumber());
        System.out.println("|  Mail:          " + contact.getEmail());
        System.out.println("|  Adress:        " + contact.getAddress());

        System.out.println("\n\n|  Do you want to search for another contact?");
        System.out.print("|  Your answer: ");
        isInputInvalid = true;

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")){
                isInputInvalid = false;
            }
            else {
                System.out.print("|  Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        if (input.equalsIgnoreCase("yes")){
            seeDetails(contacts);
        }
    }

    public static void editContact() {

    }

    public static void addAContact(){

    }

    public static void deleteAContact(){

    }

}
