package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final int CALCMETHOD = 3;
    private static final int COUNTROUNDS = 3; //Кол-во раундов - 3
    private static String[] questSaver = new String[COUNTROUNDS];
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static final double THETHIRDPART = 0.33; //Т.к операторов 3 - то вероятность выбора одного из них - 1 / 3
    private static final double TWOTHIRDS = 0.66; //Вероятность выбора ТРЕТЬЕГО оператора

    public static String[] calcing() {
        String[] correctAnswers = new String[COUNTROUNDS]; //Создание массива ,
 //в котором будут правильные ответы(на 3 раунда)

        for (int i = 0; i < COUNTROUNDS; i++) {
            int firstValue = (int) (Math.random() * FACTOR);
            int secondValue = (int) (Math.random() * FACTOR);
            double operator = Math.random(); //Генерирует число для постановки оператора
            //Вероятность второго не нужна - т.к она больше первого , но меньше третьего
            if (operator <= THETHIRDPART) { //Если число меньше трети - то оператор - сложение
                correctAnswers[i] = String.valueOf(firstValue + secondValue);
                questSaver[i] = firstValue + " + " + secondValue;
            } else if (operator > THETHIRDPART && operator < TWOTHIRDS) {
                correctAnswers[i] = String.valueOf(firstValue * secondValue);
                questSaver[i] = firstValue + " * " + secondValue;
            } else {
                correctAnswers[i] = String.valueOf(firstValue - secondValue);
                questSaver[i] = firstValue + " - " + secondValue;
            }
        }
        return correctAnswers;
    }

    public static String[] getQuest() {
        return questSaver;
    }

    public static void text() {
        System.out.println("What is the result of the expression?");
    }
    public static void play() {
        Engine.starter(CALCMETHOD, calcing(), getQuest());
    }
}
