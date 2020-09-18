package contact.utilities;

import contact.dataBase.Contact;
import contact.dataBase.DataBase;

import java.util.*;

public class Options {

    static Scanner scn = new Scanner(System.in);

    public static void seeDetails(Set<Contact> contacts) {
        boolean isInputInvalid = true;
        boolean isBooleanTrue = true;
        boolean isAnyError = false;
        String input;
        String name;
        int nameLength;
        int intInput = 0;
        Contact contact;
        List<Contact> contactList = new ArrayList<>();
        Iterator<Contact> iterator = contacts.iterator();

        for (int i = 0; i < contacts.size(); i++) {
            contact = iterator.next();
            contactList.add(contact);
        }

        System.out.println("\n|  Enter the index of the contact!");



        do {
            try {
                do {
                    if (isAnyError){
                        System.out.print("|  Please enter a valid input: ");
                    }
                    else {
                        System.out.print("|  Your answer: ");
                    }
                    input = scn.next();
                    if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= contacts.size()) {
                        isInputInvalid = false;
                    } else {
                        System.out.print("\n|  Please enter a valid input\n");
                    }
                }
                while (isInputInvalid);
                isAnyError = false;
                intInput = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                isAnyError = true;
            }
        }
        while (isAnyError);

        intInput--;
        contact = contactList.get(intInput);
        Messages.printContactDetails(contact);

        System.out.println("\n\n|  Do you want to search for another contact?");
        System.out.print("|  Your answer: ");
        isInputInvalid = true;

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                isInputInvalid = false;
            } else {
                System.out.print("|  Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        if (input.equalsIgnoreCase("yes")) {
            seeDetails(contacts);
        }
        else {
            App.brain(contacts);
        }
    }

    public static void editContact(Set<Contact> contacts) {
        System.out.println("\n\n");
        DataBase.printDataBase(contacts);

        System.out.println("\n\n\n|  Enter the index of the contact you want to edit:");

        boolean isInputInvalid = true;
        boolean isBooleanTrue = true;
        boolean isAnyError = false;
        String input;
        String name;
        int nameLength;
        int intInput = 0;
        Contact contact;
        List<Contact> contactList = new ArrayList<>();
        Iterator<Contact> iterator = contacts.iterator();


        for (int i = 0; i < contacts.size(); i++) {
            contact = iterator.next();
            contactList.add(contact);
        }

        do {
            try {
                do {
                    if (isAnyError){
                        System.out.print("|  Please enter a valid input: ");
                    }
                    else {
                        System.out.print("|  Your answer: ");
                    }
                    input = scn.next();
                    if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= contacts.size()) {
                        isInputInvalid = false;
                    } else {
                        System.out.print("\n|  Please enter a valid input\n");
                    }
                }
                while (isInputInvalid);
                isAnyError = false;
                intInput = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                isAnyError = true;
            }
        }
        while (isAnyError);

        contact = contactList.get(intInput - 1);

        System.out.println("\n|  You have selected:");
        Messages.printContactDetails(contact);

        System.out.println("\n\n|  1. Edit this contact");
        System.out.println("|  2. Select another contact");
        System.out.print("|  Your answer: ");

        isInputInvalid = true;

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")){
                isInputInvalid = false;
            }
            else {
                System.out.print("Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        if (input.equalsIgnoreCase("1")){
            System.out.println("\n|  What do you want to edit?");
            System.out.println("|  1. Name");
            System.out.println("|  2. Phone Number");
            System.out.println("|  3. Mail");
            System.out.println("|  4. Adress");

            System.out.print("|  Your answer: ");
            isInputInvalid = true;
            do {
                input = scn.next();
                if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")
                    || input.equalsIgnoreCase("3") || input.equalsIgnoreCase("4")){
                    isInputInvalid = false;
                }
                else {
                    System.out.print("Please enter a valid input: ");
                }
            }
            while (isInputInvalid);

            switch (input){
                case "1":
                    EditContact.editName(contact);
                    contacts.addAll(changeContact(intInput, contactList, contact));
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
            }
        }
        else {
            editContact(contacts);
        }

        DataBase.printDataBase(contacts);

    }



    public static void addAContact() {

    }

    public static void deleteAContact() {

    }

    public static void closeApp(){

    }


    public static Set<Contact> changeContact(int intInput, List<Contact> contactList, Contact contact){
        Set<Contact> contacts = new HashSet<>();

        contactList.remove(intInput - 1);
        contactList.add(intInput - 1, contact);

        System.out.println("\n\n\n\n");

        contacts.addAll(contactList);

        return contacts;
    }
}
