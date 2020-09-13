package contact.utilities;

import java.util.Scanner;

public class App {

    static Scanner scn = new Scanner(System.in);
    public static void brain(){
        boolean isInputInvalid = true;
        String input;

        Messages.whatToDo();
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
                Options.seeDetails();
                break;
            case "2":
                Options.editContact();
                break;
            case "3":
                Options.addAContact();
                break;
            case "4":
                Options.deleteAContact();
                break;
        }
    }
}
