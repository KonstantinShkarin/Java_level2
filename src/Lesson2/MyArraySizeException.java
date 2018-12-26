package Lesson2;

public class MyArraySizeException extends Exception {
    private String[] arr;

    public MyArraySizeException(String message, String[] arr) {
        super(message);
        this.arr = arr;
    }
}
