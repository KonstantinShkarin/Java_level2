package Lesson2;

public class J2Lesson2 {
    private String[][] arr;
    final static int SIZE = 4;

    public J2Lesson2(String[][] arr) throws MyArraySizeException {

        this.arr = new String[SIZE][SIZE];
                if ((arr[0].length != SIZE) || (arr.length != SIZE)) {
                    throw new MyArraySizeException("Размер задан неверно", arr);
                }
            }
        }
