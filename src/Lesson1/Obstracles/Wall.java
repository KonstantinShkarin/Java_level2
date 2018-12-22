package Lesson1.Obstracles;

import Lesson1.Competitors.Competitor;
import Lesson1.Obstracles.Obstracle;

public class Wall extends Obstracle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
