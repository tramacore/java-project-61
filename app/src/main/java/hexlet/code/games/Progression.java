package hexlet.code.games;

import java.util.Arrays;

public class Progression {
    private static int answer;//Переменная , в которой будет правильный ответ

    public static int[] progress() {
        int generate = (int) (Math.random() * 10);//Создание длины начального массива
        while (generate < 5) {// По условию массив должен быт не менее 5 чисел
            generate = (int) (Math.random() * 10);
        }
        int[] arrayToShow = new int[generate];//Создание самого массива , длиной заданной выше
        arrayToShow[0] = (int) (Math.random() * 100);//Задание первого числа массива
        int x;
        do {
            x = (int) (Math.random() * 10);//Задание числа , которое будет законом для прогрессии
        } while (x == 0);//оно не будет = 0 , тк в таком случае вся прогрессия равна первому числу
        for (int i = 1; i < generate; i++) {
            arrayToShow[i] = arrayToShow[i - 1] + x;/*Задание прогрессии , путем что следующий элемент
                                            массива = предыдущее + число-закон  */
        }
        return arrayToShow;
    }

    public static String[] hidder(int[] arr) {//СОздаст массив , который будет прятать число в себе
        int x = (int) (Math.random() * 100);//Задает каким по порядку будет спрятанное число
        String[] arrToHide = new String[arr.length];//Создание самого массива , длиной массива с метода progress
        while (x >= arr.length) {
            x = (int) (Math.random() * 100);//Необходимо чтобы число не выходило за рамки длины массива
        }
        for (int i = 0; i < arr.length; i++) {//Цикл , который проходит по массиву и
            if (i == x) {//                                         в месте X (созданной и отрегулированнной выше)
                answer = arr[x];                   //подставит ..
                arrToHide[x] = "..";
            } else {
                arrToHide[i] = arr[i] + "";
            }
        }
        return arrToHide;
    }

    public static void printArray() {
        String[] arrayToPrint = hidder(progress());
        for (int i = 0; i < arrayToPrint.length; i++) {
            if (i != arrayToPrint.length - 1) {
                System.out.print(arrayToPrint[i] + " ");
            }
        }
    }

    public static int getAnswer() {
        return answer;
    }

    public static void text() {
        System.out.println("What number is missing in the progression?");
    }
}
