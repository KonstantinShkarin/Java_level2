package Lesson2;

public class MyArrayDataException extends Exception {
    private int number;

    public MyArrayDataException(String message, int number) {
        super(message);
        this.number = number;
    }
}



