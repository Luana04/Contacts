package contact;

import contact.dataBase.Contact;
import contact.dataBase.DataBase;
import contact.utilities.App;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

public class Main {

    private static final String FILE_NAME = "contacts.csv";

    public static void main(String[] args) {

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        }
        catch (FileNotFoundException ex){
            System.out.println("File " + FILE_NAME + " not found!");
        }

        Set<Contact> contacts = DataBase.getDataBase();
        DataBase.printDataBase(contacts);

        App.brain(contacts);




        }

}
