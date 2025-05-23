package lesson2_2;

public class Main {

   public static void printThreeWords() {                //1
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {          //2
        int a = 5;
        int b = -7;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {             //3
        int value = 110;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {           //4
        int a = 2;
        int b = 3;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean sumInRange(int a, int b) {             //5
        int sum = (a + b);
        return sum >= 10 && sum <= 20;
    }

    public static void positiveOrNegative(int number) {            //6
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean negative(int number) {                //7
        return number < 0;
   }

    public static void stringCounts(String str, int count) {                //8
        for (int index = 0; index < count; index++) {
            System.out.println(str);
        }
    }

    public static boolean stringAndNumber(int year) {                //9
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void invertArray(int[] arr) {                  //10
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == 0) {
                arr[index] = 1;
            } else {
                arr[index] = 0;
            }
        }
    }

    public static int[] fillArray() {                         //11
        int[] arr = new int[100];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = index + 1;
        }
        return arr;
    }

    public static void lessThanSix(int[] arr) {              //12
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] < 6) {
                arr[index] *= 2;
            }
        }
    }

    public static void diagonal(int[][] matrix) {                 //13
        for (int index = 0; index < matrix.length; index++) {
            matrix[index][index] = 1;
        }
    }

    public static int[] returningArray(int len, int initialValue) {                    //14
        int[] arr = new int[len];
        for (int index = 0; index < len; index++) {
            arr[index] = initialValue;
        }
        return arr;
    }

                       // Вызовы


    public static void main(String[] args) {

        System.out.println("\n1. printThreeWords");
        printThreeWords();

        System.out.println("\n2. checkSumSign");
        checkSumSign();

        System.out.println("\n3. printColor");
        printColor();

        System.out.println("\n4. compareNumbers");
        compareNumbers();

        System.out.println("\n5. sumInRange");
        System.out.println(sumInRange(5, 6));
        System.out.println(sumInRange(2, 2));

        System.out.println("\n6. positiveOrNegative");
        positiveOrNegative(0);
        positiveOrNegative(-1);

        System.out.println("\n7. negative");
        System.out.println(negative(-1));
        System.out.println(negative(0));

        System.out.println("\n8. stringCounts");
        stringCounts("Hello World", 3);

        System.out.println("\n9. stringAndNumber");
        System.out.println("2012: " + stringAndNumber(2012));
        System.out.println("2000: " + stringAndNumber(2000));
        System.out.println("1900: " + stringAndNumber(1900));

        System.out.println("\n10. invertArray");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(arr);
        for (int val : arr) System.out.print(val + " ");
        System.out.println();

        System.out.println("\n11. fillArray");
        int[] arr11 = fillArray();
        for (int val : arr11) System.out.print(val + " ");
        System.out.println();

        System.out.println("\n12. lessThanSix");
        int[] arr12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        lessThanSix(arr12);
        for (int val : arr12) System.out.print(val + " ");
        System.out.println();

        System.out.println("\n13. diagonal");
        int[][] matrix = new int[10][10];
        diagonal(matrix);
        for (int index = 0; index < matrix.length; index++) {
            for (int index_b = 0; index_b < matrix[index].length; index_b++) {
                System.out.print(matrix[index][index_b] + " ");
            }
            System.out.println();
        }

        System.out.println("\n14. returningArray");
        int[] arr14 = returningArray(11, 11);
        for (int val : arr14) System.out.print(val + " ");
        System.out.println();
    }
}
































