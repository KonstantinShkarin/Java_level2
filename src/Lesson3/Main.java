/*
@Konstantin Shkarin
28.12.2018
Java 2 lesson 3
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
делать взаимодействие с пользователем через консоль и т.д.).
Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().

*/

package Lesson3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>(20);
        al.add("Тыква");
        al.add("Кабачок");
        al.add("Картофель");
        al.add("Морковь");
        al.add("Тыква");
        al.add("Фасоль");
        al.add("Кабачок");
        al.add("Картофель");
        al.add("Морковь");
        al.add("Тыква");
        al.add("Баклажан");

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Integer value;
        for (String s : al) {
            value = hm.get(s);
            if (value == null) hm.put(s, 1);
            else hm.put(s, value + 1);
        }
        System.out.println(al);
        System.out.println(hm);

        System.out.println("_______________________");



      PhoneBookNew phoneBookNew = new PhoneBookNew();

      phoneBookNew.add ("Ivanov", 567893);
      phoneBookNew.add ("Petrov", 467892);
      phoneBookNew.add ("Sidorov", 6784367);

      phoneBookNew.getName();
      

        }
    }

