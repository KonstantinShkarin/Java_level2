package Lesson1;

import Lesson1.Obstracles.Cross;
import Lesson1.Obstracles.Obstracle;
import Lesson1.Obstracles.Wall;
import Lesson1.Obstracles.Water;

public class Course {
    String name;
    Obstracle[] obstracles;

    public Course(String name) {
        this.name = name;
        this.obstracles = new Obstracle[]{new Cross(80), new Wall(5), new Water(30)};
    }

    public void doIt(Team team) {
        for (Obstracle o : obstracles) {
            team.doIt(o);
        }
    }
}



