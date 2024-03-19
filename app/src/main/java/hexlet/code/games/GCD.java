package hexlet.code.games;

public class GCD {
    public static final int COUNTROUNDS = 3; //Кол-во раундов - 3
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static String[] quests = new String[COUNTROUNDS]; //Массив с заданием

    public static int[] gcdeing() {
        int[] answers = new int[COUNTROUNDS]; //Массив с ответами
        for (int i = 0; i < COUNTROUNDS; i++) {
            int x = (int) (Math.random() * FACTOR); //Создание двух чисел для задания
            int y = (int) (Math.random() * FACTOR);
            quests[i] = x + " " + y; //Присвоение i элементу массива строку с заданием
            answers[i] = findGCD(x, y); //Присвоение i элементу массива число с правильным ответом
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
}
