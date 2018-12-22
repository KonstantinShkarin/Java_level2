package Lesson1.Obstracles;

import Lesson1.Competitors.Competitor;

public class Water extends Obstracle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}
