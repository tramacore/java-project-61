package hexlet.code;

import hexlet.code.games.Progression;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    private static final int COUNTMAX = 3;
    private static final int EVENMETHOD = 2;
    private static final int CALCMETHOD = 3;
    private static final int GCDMETHOD = 4;
    private static final int PROGRESSIONMETHOD = 5;
    private static final int PRIMEMETHOD = 6;

    public static void win(int count) {
        if (count != COUNTMAX) {
            System.out.println("Correct!");
        } else {
            System.out.println("Congratulations, " + Cli.getName() + "!");
        }
    }

    public static void starter(int numberOfGame) {
        Cli.nameReciever();
        int counter = 0;
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        String[] arrayAnswer = new String[3];
        if (numberOfGame == EVENMETHOD) {
            Even.text();
            arrayAnswer = Even.even();
            int[] arrayIntAnswer = Even.getQuest();
            for (; counter < COUNTMAX;) {
                questViewer(String.valueOf(arrayIntAnswer[counter]));
                answerWaiter();
                answer = answerScanner.nextLine();
                if (answer.equals(arrayAnswer[counter])) {
                    counter++;
                    win(counter);
                } else {
                    wrongAnswer(answer, arrayAnswer[counter]);
                    return;
                }
            }
        }
        if (numberOfGame == CALCMETHOD) {
            int[] arrayAnswerCalc = Calc.calcing();
            String[] arrayQuestsCalc = Calc.getQuest();
            Calc.text();
            for (; counter < COUNTMAX;) {
                questViewer(arrayQuestsCalc[counter]);
                answerWaiter();
                answer = answerScanner.next();
                if (Integer.parseInt(answer) == arrayAnswerCalc[counter]) {
                    counter++;
                    win(counter);
                } else {
                    wrongAnswer(answer, String.valueOf(arrayAnswerCalc[counter]));
                    return;
                }
            }
        }
        if (numberOfGame == GCDMETHOD) {
            int[] arrayAnswerGcd = GCD.gcdeing();
            GCD.text();
            for (; counter < COUNTMAX;) {
                questViewer(GCD.getCorrectAnswer()[counter]);
                answerWaiter();
                answer = answerScanner.next();
                if (Integer.parseInt(answer) == arrayAnswerGcd[counter]) {
                    counter++;
                    win(counter);
                } else {
                    wrongAnswer(answer, String.valueOf(arrayAnswerGcd[counter]));
                    return;
                }
            }
        }
        if (numberOfGame == PROGRESSIONMETHOD) {
            Progression.text();
            for (; counter < COUNTMAX;) {
                System.out.print("Question: ");
                Progression.printArray();
                System.out.println();
                answerWaiter();
                answer = answerScanner.next();
                if (Integer.parseInt(answer) == Progression.getAnswer()) {
                    counter++;
                    win(counter);
                } else {
                    wrongAnswer(answer, String.valueOf(Progression.getAnswer()));
                    return;
                }
            }
        }
        if (numberOfGame == PRIMEMETHOD) {
            Prime.text();
            for (; counter < COUNTMAX;) {
                String correctAnswer = Prime.primer();
                questViewer(String.valueOf(Prime.getQuest()));
                answerWaiter();
                answer = answerScanner.next();
                if (answer.equals(correctAnswer)) {
                    counter++;
                    win(counter);
                } else {
                    wrongAnswer(answer, correctAnswer);
                    return;
                }
            }
        }
    }

    private static void questViewer(String quest) {
        System.out.println("Question: " + quest);
    }

    private static void wrongAnswer(String answer, String correctAnswer) {
        System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was "
                + "\'" + correctAnswer + "\'\n" + "Let's try again, " + Cli.getName() + "!");
    }

    private static void answerWaiter() {
        System.out.print("Your answer : ");
    }
}
