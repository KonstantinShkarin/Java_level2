package Lesson3;


import java.util.TreeMap;

public class PhoneBookNew {
    private TreeMap<String, Phones> contact;

    public PhoneBookNew() {
        contact = new TreeMap<>();
    }

    public void addContact(String name, Phones phone){
        contact.put(name, phone);
    }


public void getName (String name) {
        Phones phones = contact.get(name);
        if (phones !=null) System.out.println(phones.getPhones());
    }
};
