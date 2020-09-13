package contact;

import com.github.javafaker.Faker;
import contact.dataBase.DataBase;
import contact.utilities.App;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    private static final String FILE_NAME = "contacts.csv";

    public static void main(String[] args) {

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        }
        catch (FileNotFoundException ex){
            System.out.println("File " + FILE_NAME + " not found!");
        }


        DataBase.printDataBase(DataBase.getDataBase());

        App.brain();

//        dataBase.printList(DataBase.getDataBase());



        }

}
