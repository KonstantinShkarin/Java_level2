package Lesson1;



import Lesson1.Competitors.Cat;
import Lesson1.Competitors.Competitor;
import Lesson1.Competitors.Dog;
import Lesson1.Competitors.Human;
import Lesson1.Obstracles.Obstracle;

public class Team {
    String name;
    Competitor[] competitors;

    public Team(String name) {
        this.name = name;
        this.competitors = new Competitor[]{new Cat("Barsik"), new Dog("Zhuchka"), new Human("Ivan")};;
    }

   public void doIt (Obstracle obstracle){
       for (Competitor c: competitors) {
           obstracle.doIt(c);
           if (!c.isDistance())
               break;
       }
    }
    public void showResults () {
        for (Competitor c: competitors) {
            c.info();
        }
    }
}
