package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static String[] quests = new String[Engine.ROUNDS]; //Массив с заданием

    public static String[] gcdeing() {
        String[] answers = new String[Engine.ROUNDS]; //Массив с ответами
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int x = (int) (Math.random() * FACTOR); //Создание двух чисел для задания
            int y = (int) (Math.random() * FACTOR);
            quests[i] = x + " " + y; //Присвоение i элементу массива строку с заданием
            answers[i] = String.valueOf(findGCD(x, y)); //Присвоение i элементу массива число с правильным ответом
        }
        return answers;
    }

    public static String[] getQuests() {
        return quests;
    }

    public static int findGCD(int a, int b) { //Само нахождение наибольшего общего делителя
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void text() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static void play(String name) {
        Engine.starter(gcdeing(), getQuests(), name);
    }
}
