package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3; //Максимальное число раундов

    public static void starter(String[][] answersGame, String description) {
        Scanner answerScanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String name = answerScanner.next();
        System.out.printf("Hello, %s!\n" + description + "\n", name);
        for (String[] questionAnswer : answersGame) {
            System.out.print("Question: " + questionAnswer[0] + "\nYour answer : ");
            String answer = answerScanner.next();
            if (answer.equals(questionAnswer[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was "
                        + "\'" + questionAnswer[1] + "\'\n" + "Let's try again, " + name + "!");
                answerScanner.close();
                return;
            }

        }
        System.out.println("Congratulations, " + name + "!");
        answerScanner.close();
    }
}
