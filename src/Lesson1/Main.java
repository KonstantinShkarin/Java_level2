package Lesson1;

public class Main {

    public static void main(String[] args) {
        Team team = new Team("Команда");
        Course course = new Course("Препятствия");
        course.doIt(team);
        team.showResults();
    }
}
