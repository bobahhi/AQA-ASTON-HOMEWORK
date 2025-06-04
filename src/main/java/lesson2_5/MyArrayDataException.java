package lesson2_5;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super("Ошибка в ячейке [" + row + "][" + col + "]: '" + value + "' не число!");
    }
}