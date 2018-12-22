package Lesson1.Obstracles;

import Lesson1.Competitors.Competitor;

public class Cross extends Obstracle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
