package hexlet.code.games;

public class GCD {
    private static String[] correctAnswer = new String[3];

    public static int[] gcdeing() {
        int[] answers = new int[3];
        for (int i = 0; i < 3; i++) {
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
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
