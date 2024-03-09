package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void win(int count) {
        if (count != 3) {
            System.out.println("Correct!");
        } else {
            System.out.println("Congratulations," + Cli.getName());
        }
    }

    public static void starter(int numberOfGame) {
        Cli.nameReciever();
        String quest;
        String correctAnswer;
        int counter = 0;
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        String[] arrayAnswer = new String[3];
        switch (numberOfGame) {
            case 2:
                Even.evenMessage();
                arrayAnswer = Even.even();
                int[] arrayIntAnswer = Even.getQuest();
                for (; counter < 3; ) {
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
                Calc.calcText();
                for (; counter < 3; ) {
                    questViewer(arrayQuestsCalc[counter]);
                    answerWaiter();
                    answer= answerScanner.next();
                    if(Integer.parseInt(answer) == arrayAnswerCalc[counter]) {
                        counter++;
                        win(counter);
                    } else {
                wrongAnswer(answer, String.valueOf(arrayAnswerCalc[counter]));
                return;
            }
                }
        }
    }

    private static void questViewer(String quest) {
        System.out.println("Question : " + quest);
    }

    private static void wrongAnswer(String answer, String correctAnswer) {
        System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was " +
                "\'" + correctAnswer + "\'");
    }
    private static void answerWaiter() {
        System.out.print("Your answer : ");
    }
}
