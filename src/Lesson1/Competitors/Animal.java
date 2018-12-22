package Lesson1;

public class Animal implements Competitor {
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist<=maxRunDistance){
            System.out.println(type+" "+name+"Успешно пробежал");
        } else {
            System.out.println("Дистанция не пройдена");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist<=maxSwimDistance){
            System.out.println(type+" "+name+"Успешно проплыл");
        } else {
            System.out.println("Дистанция не пройдена");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height<=maxJumpDistance){
            System.out.println(type+" "+name+"Успешно перепрыгнул");
        } else {
            System.out.println("Дистанция не пройдена");
            onDistance = false;
        }
    }

    @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type+" "+name+" "+onDistance);

    }
}
