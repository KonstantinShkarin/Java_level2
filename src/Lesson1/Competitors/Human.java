package Lesson1.Competitors;

public class Human implements Competitor {
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpDistance;

    boolean active;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxSwimDistance = 200;
        this.maxJumpDistance = 30;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist<=maxRunDistance){
            System.out.println(" "+name+"Успешно пробежал");
        } else {
            System.out.println("Дистанция не пройдена");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist<=maxSwimDistance){
            System.out.println(" "+name+"Успешно проплыл");
        } else {
            System.out.println("Дистанция не пройдена");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height<=maxJumpDistance){
            System.out.println(" "+name+"Успешно перепрыгнул");
        } else {
            System.out.println("Дистанция не пройдена");
            active = false;
        }
    }

    @Override
    public boolean isDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(" "+name+" "+active);
    }
}
