package src.Exercise_6_Abstraction_Question_1;

import java.util.ArrayList;

public abstract class Phone {

    protected ArrayList<Contacts> contacts;

    public Phone(){
        contacts = new ArrayList<>();
    }

    public ArrayList<Contacts> getContacts() {
        return contacts;
    }

    abstract void insertContact(String name, String phone);
    abstract void removeContact(String name);
    abstract void updateContact(String name, String newPhone);
    abstract void searchContact(String name);


}
