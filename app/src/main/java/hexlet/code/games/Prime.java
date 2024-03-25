package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {

    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1
    // - то умножаем это число на 100
    private static String[] quest = new String[Engine.ROUNDS];

    public static String[] primer() {
        String[] answers = new String[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int value = (int) (Math.random() * FACTOR);
            quest[i] = String.valueOf(value);
            if (value < 2) {
                answers[i] = "no";
                continue;
            }
            answers[i] = "yes";
            for (int j = 2; j <= value / 2; j++) {
                if (value % j == 0) {
                    answers[i] = "no";
                    break;
                }
            }
        }
        return answers;
    }


    public static String[] getQuest() {
        return quest;
    }

    public static void text() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public static void play(String name) {
        Engine.starter(primer(), getQuest(), name);
    }
}
