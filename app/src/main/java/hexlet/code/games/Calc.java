package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final int CALCMETHOD = 3;
    private static String[] questSaver = new String[Engine.ROUNDS];
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static final double THETHIRDPART = 0.33; //Т.к операторов 3 - то вероятность выбора одного из них - 1 / 3
    private static final double TWOTHIRDS = 0.66; //Вероятность выбора ТРЕТЬЕГО оператора

    public static String[] calcing() {
        String[] correctAnswers = new String[Engine.ROUNDS]; //Создание массива ,
        //в котором будут правильные ответы(на 3 раунда)

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstValue = (int) (Math.random() * FACTOR);
            int secondValue = (int) (Math.random() * FACTOR);
            double operator = Math.random(); //Генерирует число для постановки оператора
            correctAnswers[i] = String.valueOf(operating(operator, firstValue, secondValue));
            questSaver[i] = mathExp(operator, firstValue, secondValue);
        }
        return correctAnswers;
    }

    private static int operating(double factor, int firstValue, int secondValue) {
        if (factor <= THETHIRDPART) { //Если число меньше трети - то оператор - сложение
            return firstValue + secondValue;
        } else if (factor > THETHIRDPART && factor < TWOTHIRDS) {
            return firstValue * secondValue;
        } else {
            return firstValue - secondValue;
        }
    }

    private static String mathExp(double factor, int firstValue, int secondValue) {
        if (factor <= THETHIRDPART) { //Если число меньше трети - то оператор - сложение
            return firstValue + " + " + secondValue;
        } else if (factor > THETHIRDPART && factor < TWOTHIRDS) {
            return firstValue + " * " + secondValue;
        } else {
            return firstValue + " - " + secondValue;
        }
    }

    public static String[] getQuest() {
        return questSaver;
    }

    public static void text() {
        System.out.println("What is the result of the expression?");
    }

    public static void play(String name) {
        Engine.starter(CALCMETHOD, calcing(), getQuest(), name);
    }
}
