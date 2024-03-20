package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static final int FACTORTOLENGTH = 10; //т.к Math.random() генерирует число от 0 до 1 -
    private static final int COUNTROUNDS = 3;                                                                              // то умножаем это число на 10
    private static final int MAXDIGIT = 5; // По условию массив должен быт не менее 5 чисел
    //для создания массива до 10 символов
    private static String[] answers = new String[COUNTROUNDS];

    public static int[] progress() {
        int generate = (int) (Math.random() * FACTORTOLENGTH); //Создание длины начального массива
        while (generate < MAXDIGIT) {
            generate = (int) (Math.random() * FACTORTOLENGTH);
        }
        int[] arrayToShow = new int[generate]; //Создание самого массива , длиной заданной выше
        arrayToShow[0] = (int) (Math.random() * FACTOR); //Задание первого числа массива
        int x;
        do {
            x = (int) (Math.random() * FACTORTOLENGTH); //Задание числа , которое будет законом для прогрессии
        } while (x == 0); //оно не будет = 0 , тк в таком случае вся прогрессия равна первому числу
        for (int i = 1; i < generate; i++) {
            arrayToShow[i] = arrayToShow[i - 1] + x; /*Задание прогрессии , путем что следующий элемент
                                            массива = предыдущее + число-закон  */
        }
        return arrayToShow;
    }

    public static String[] hidder() { //Создаст массив , который будет прятать число в себе
        String[] answer = new String[COUNTROUNDS];
        String saver = "";
        for (int i = 0; i < COUNTROUNDS; i++) {
            saver = "";
            int x = (int) (Math.random() * FACTOR); //Задает каким по порядку будет спрятанное число
            int[] arrToHide = progress();//Создание самого массива , длиной массива с метода progress
            while (x >= arrToHide.length) {
                x = (int) (Math.random() * FACTOR);//Необходимо чтобы число не выходило за рамки длины массива
            }
            answer[i] = String.valueOf(arrToHide[x]);
            for (int j = 0; j < arrToHide.length; j++) { //Цикл , который проходит по массиву и
                if (j == x) {                            //в месте X (созданной и отрегулированнной выше)
                    saver += ".. ";                 //подставит ".."
                } else {
                    saver += arrToHide[j] + " ";
                }
            }
            answers[i] = saver;
        }
        return answer;
    }

    public static String[] getAnswers() {
        return answers;
    }


    public static void play() {
        Engine.starter(5, hidder(), getAnswers());
    }
}
