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
        switch (numberOfGame) {
            case 2:
                Even.evenMessage();
                Even.even();
                String[] arrayAnswer = Even.even();
                int[] arrayIntAnswer = Even.getQuest();
                for (; counter < 3; ) {
                    questViewer(String.valueOf(arrayIntAnswer[counter]));
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
    }

    private static void questViewer(String quest) {
        System.out.println("Question : " + quest);
    }

    private static void wrongAnswer(String answer, String correctAnswer) {
        System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was " +
                "\'" + correctAnswer + "\'");
    }
}
