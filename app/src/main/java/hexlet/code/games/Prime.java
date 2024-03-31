package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static String[][] primer() {
        String[][] answers = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int value = Utils.generateNumber(0, Engine.MAXVALUE);
            answers[i][0] = String.valueOf(value);
            if (isPrime(value)) {
                answers[i][1] = "yes";
            } else {
                answers[i][1] = "no";
            }
        }
        return answers;
    }

    private static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }
        for (int j = 2; j <= value / 2; j++) {
            if (value % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void play() {
        String descriprion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.starter(primer(), descriprion);
    }
}
