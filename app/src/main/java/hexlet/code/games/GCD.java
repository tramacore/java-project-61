package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    public static String[][] gcdGetAnswer() {
        final int maxvalue = 100;
        String[][] answers = new String[Engine.ROUNDS][2]; //Массив с ответами
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int x = Utils.generateNumber(0, maxvalue);
            int y = Utils.generateNumber(0, maxvalue);
            answers[i][0] = x + " " + y; //Присвоение i элементу массива строку с заданием
            answers[i][1] = String.valueOf(gcd(x, y)); //Присвоение i элементу массива число с правильным ответом
        }
        return answers;
    }

    public static int gcd(int a, int b) { //Само нахождение наибольшего общего делителя
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void play() {
        String description = "Find the greatest common divisor of given numbers.";
        Engine.starter(gcdGetAnswer(), description);
    }
}
