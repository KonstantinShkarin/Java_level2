package Lesson3;

import java.util.ArrayList;

public class Phones {
    private ArrayList<String> phones;

  public Phones (String phone) {
     this.phones = new ArrayList<>();
      phones.add(phone);
  }

    public String getPhones() {
        return phones.toString();

    }
}
