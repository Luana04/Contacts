package contact.utilities;

import contact.dataBase.Contact;

public class Messages {

    public static void whatToDo() {
        System.out.println("\n\n\n");
        System.out.println("|  What do you want to do?");
        System.out.println("|  1. See a contact's details");
        System.out.println("|  2. Edit a contact");
        System.out.println("|  2. Add a contact");
        System.out.println("|  4. Delete a contact");
        System.out.print("\n|  Your answer: ");

    }

    public static void printContactDetails(Contact contact){
        String name;

        name = contact.getFullName();
        int nameLength = name.length();
        nameLength--;

        boolean isBooleanTrue = true;

        while (isBooleanTrue) {
            if (contact.getFullName().charAt(nameLength) == ' ') {
                name = name.substring(0, name.length() - 1);
                nameLength--;
            } else {
                isBooleanTrue = false;
            }
        }

        System.out.println("\n|  Name:          " + name);
        System.out.println("|  Phone Number:  " + contact.getPhoneNumber());
        System.out.println("|  Mail:          " + contact.getEmail());
        System.out.println("|  Adress:        " + contact.getAddress());
    }

}
