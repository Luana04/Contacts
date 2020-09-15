package contact.utilities;

import contact.dataBase.Contact;

import java.util.Scanner;

public class EditContact {

    static Scanner scn = new Scanner(System.in);

    public static Contact editName(Contact contact){
        System.out.println("\n|  You've selected to edit contact's name");
        System.out.println("|  Old name: " + contact.getFullName());
        System.out.print("|  New name: ");

        contact.setFullName(scn.nextLine());

        System.out.println("\n|  Name successfully changed!\n\n\n|  New contact's details: ");
        Messages.printContactDetails(contact);

        return contact;
    }
}
