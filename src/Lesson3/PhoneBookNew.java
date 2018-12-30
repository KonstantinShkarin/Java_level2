package Lesson3;


import java.util.TreeMap;

public class PhoneBookNew {
    private TreeMap<String, Phones> contact;

    public PhoneBookNew() {
        contact = new TreeMap<>();
    }

    public void addContact(String name, Phones number){
        contact.put(name, number);
    }


public void getName (String name) {
        Phones phones = contact.get(name);
        if (phones !=null) System.out.println(phones.getPhones());
    }
};
