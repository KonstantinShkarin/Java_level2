package Lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class J2Lesson2 {
    private String[] arr;
    final static int SIZE = 4;

    public J2Lesson2(String[]arr) throws MyArraySizeException, MyArrayDataException {

        this.arr = arr;
        if (arr.length != SIZE) {
            throw new MyArraySizeException("Размер задан неверно", arr);
        }
        int sum = 0;
        int[] numbers = new int[SIZE];
        for (int i = 0; i<arr.length;i++) {
            numbers[i] = Integer.parseInt(arr[i]);
                if (arr[i] == null){
                    throw new MyArrayDataException("Не удалось выполнить преобразование", numbers[i]);
                }
                    sum = sum + numbers[i];
        }
        System.out.println(sum);
     }
}
