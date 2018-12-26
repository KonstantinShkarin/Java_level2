package Lesson2;

public class Main {

    public static void main(String[] args) {
        try {
            J2Lesson2 j2 = new J2Lesson2(new String[][]{{"6", "3", "3","3"},
                                                        {"4", "2", "9","1"},
                                                        {"1", "1", "1","1"},
                                                        {"6", "3", "3","6"}
            });
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}




