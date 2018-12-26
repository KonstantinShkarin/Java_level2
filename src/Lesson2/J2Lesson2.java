package Lesson2;


public class J2Lesson2 {
    private String[][] arr;
    final static int SIZE = 4;

    public J2Lesson2(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        this.arr = arr;
        if ((arr[0].length != SIZE) || (arr.length != SIZE)) {
            throw new MyArraySizeException("Размер задан неверно", arr);
        }
        int sum = 0;
        int[][] numbers = new int[SIZE][SIZE];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                numbers[i][j] = Integer.parseInt(arr[i][j]);
                    if (!arr[i][j].matches("-?\\d+(\\.\\d+)?")) {
                        throw new MyArrayDataException("Не удалось выполнить преобразование", numbers[i][j]);
                }
                sum = sum + numbers[i][j];
            }
        }
        System.out.println(sum);
    }
}
