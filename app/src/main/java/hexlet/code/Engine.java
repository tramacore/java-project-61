package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3; //Максимальное число раундов

    public static void starter(String[][] answersGame, String description) {
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        int counter = 0;
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String name = answerScanner.next();
        System.out.printf("Hello, %s!\n" + description + "\n", name);
        while (counter < ROUNDS) {
            System.out.print("Question: " + answersGame[counter][0] + "\nYour answer : ");
            answer = answerScanner.next();
            if (answer.equals(answersGame[counter][1])) {
                counter++;
                if (counter != ROUNDS) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Congratulations, " + name + "!");
                    answerScanner.close();
                }
            } else {
                System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was "
                        + "\'" + answersGame[counter][1] + "\'\n" + "Let's try again, " + name + "!");
                answerScanner.close();
                return;
            }
        }
    }
}
