package contact;

import contact.dataBase.Contact;
import contact.dataBase.DataBase;
import contact.utilities.App;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class Main {

    private static final String FILE_NAME = "contacts.csv";

    public static void main(String[] args) {

//        try {
//            BufferedWriter bw = new BufferedWriter(new FileWriter("dataBase-copy.txt"));
//            BufferedReader br = new BufferedReader(new FileReader("dataBase.txt"));
//            String s;
//            while ((s = br.readLine()) != null){
//                bw.write(s + "\n");
//            }
//            br.close();
//            bw.close();
//        }catch (Exception ex){
//            return;
//        }

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
