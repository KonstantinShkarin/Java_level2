package Lesson3;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBookNew {
    private TreeMap<String, Integer> contact;

    public PhoneBookNew() {
        contact = new TreeMap<>();
    }

    public boolean add(String name, Integer phone) {
        contact.put(name, phone);
        return false;
    }

public void getName () {
    System.out.println(contact.entrySet());
    }
};
