package hexlet.code;

import hexlet.code.games.Progression;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    public static void win(int count) {
        if (count != 3) {
            System.out.println("Correct!");
        } else {
            System.out.println("Congratulations, " + Cli.getName() + "!");
        }
    }

    public static void starter(int numberOfGame) {
        Cli.nameReciever();
        int counter = 0;
        int counterMax = 3;
        int even = 2; //При выборе
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        String[] arrayAnswer = new String[3];
        switch (numberOfGame) {
            case 2:
                Even.text();
                arrayAnswer = Even.even();
                int[] arrayIntAnswer = Even.getQuest();
                for (; counter < counterMax;) {
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
            case 3:
                int[] arrayAnswerCalc = Calc.calcing();
                String[] arrayQuestsCalc = Calc.getQuest();
                Calc.text();
                for (; counter < counterMax;) {
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
            case 4:
                int[] arrayAnswerGcd = GCD.gcdeing();
                GCD.text();
                for (; counter < counterMax;) {
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
            case 5:
                Progression.text();
                for (; counter < counterMax;) {
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
                break;
            case 6:
                Prime.text();
                for (; counter < counterMax;) {
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
                break;
            default:
                return;
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
