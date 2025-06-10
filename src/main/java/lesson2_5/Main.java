package lesson2_5;

public class Main {
    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Должно быть 4 строки, а тут " + arr.length);
        }
        for (int row = 0; row < arr.length; row++) {
            if (arr[row].length != 4) {
                throw new MyArraySizeException("В строке " + row + " должно быть 4 столбца, а тут " + arr[row].length);
            }
        }

        int sum = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                try {
                    sum += Integer.parseInt(arr[row][col]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(row, col, arr[row][col]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("Сумма элементов массива: " + sumArray(correctArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "пятнадцать", "16"}
        };

        try {
            System.out.println("Ошибка данных массива: " + sumArray(wrongDataArray));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] arr = new int[5];
            System.out.println(arr[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}