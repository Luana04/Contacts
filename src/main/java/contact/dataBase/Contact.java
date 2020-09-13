package contact.dataBase;

import com.github.javafaker.Address;
import com.github.javafaker.Beer;
import com.github.javafaker.FunnyName;

import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Contact {

    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(String fullName, String phoneNumber, String email, String address) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}