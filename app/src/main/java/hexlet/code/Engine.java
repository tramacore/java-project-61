package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int COUNTMAX = 3; //Максимальное число раундов
    private static final int EVENMETHOD = 2; //Назначения своего числа каждой игре
    private static final int CALCMETHOD = 3;
    private static final int GCDMETHOD = 4;
    private static final int PROGRESSIONMETHOD = 5;
    private static final int PRIMEMETHOD = 6;
    private static String[] arrayAnswer = new String[COUNTMAX];

    public static void win(int count) { //Метод отвечающий за вывод в случае победы в раунде и в игре
        if (count != COUNTMAX) {
            System.out.println("Correct!");
        } else {
            System.out.println("Congratulations, " + Cli.getName() + "!");
        }
    }

    public static void starter(int game, String[] answersGame, String[] quests) {
        Scanner answerScanner = new Scanner(System.in);
        descriprion(game);
        String answer;
        int counter = 0;
        for (; counter < 3; ) {
            questViewer(quests[counter]);
            answerWaiter();
            answer = answerScanner.next();
            if (answer.equals(answersGame[counter])) {
                counter++;
                win(counter);
                if (counter == COUNTMAX) {
                    answerScanner.close();
                }
            } else {
                wrongAnswer(answer, answersGame[counter]);
                answerScanner.close();
                return;
            }
        }
    }

    private static void questViewer(String quest) {
        System.out.println("Question: " + quest);
    } //Вывод задания

    private static void wrongAnswer(String answer, String correctAnswer) { //Вывод неверного ответа
        System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was "
                + "\'" + correctAnswer + "\'\n" + "Let's try again, " + Cli.getName() + "!");
    }

    private static void answerWaiter() {
        System.out.print("Your answer : ");
    }

    private static void descriprion(int numberOfGame) {
        if (numberOfGame == EVENMETHOD) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        }
        if (numberOfGame == CALCMETHOD) {
            System.out.println("What is the result of the expression?");
        }
        if (numberOfGame == GCDMETHOD) {
            System.out.println("Find the greatest common divisor of given numbers.");
        }
        if (numberOfGame == PROGRESSIONMETHOD) {
            System.out.println("What number is missing in the progression?");
        }
        if (numberOfGame == PRIMEMETHOD) {
            System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        }
    }
}
