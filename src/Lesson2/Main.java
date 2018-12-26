package Lesson2;

public class Main {

    public static void main(String[] args) {
        try {
            J2Lesson2 j2 = new J2Lesson2(new String[4][4]);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

    }
    }



      /*
        String[][] arr = {
                {"23", "23", "4", "5"},
                {"43", "54", "23", "54"},
                {"43", "45", "5", "54"},
                {"54", "54", "46", "54"}};

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i][j]+" ");
            }
        System.out.print(" ");
*/

