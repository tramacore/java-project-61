package hexlet.code.games;

public class GCD {
    public static final int COUNTROUNDS = 3; //Кол-во раундов - 3
    private static final int factor = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static String[] correctAnswer = new String[COUNTROUNDS];

    public static int[] gcdeing() {
        int[] answers = new int[COUNTROUNDS];
        for (int i = 0; i < COUNTROUNDS; i++) {
            int x = (int) (Math.random() * factor);
            int y = (int) (Math.random() * factor);
            correctAnswer[i] = x + " " + y;
            answers[i] = findGCD(x, y);
        }
        return answers;
    }

    public static String[] getCorrectAnswer() {
        return correctAnswer;
    }

    public static int findGCD(int a, int b) {
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
