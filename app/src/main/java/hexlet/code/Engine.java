package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3; //Максимальное число раундов

    public static void win(int count, String name) { //Метод отвечающий за вывод в случае победы в раунде и в игре
        if (count != ROUNDS) {
            System.out.println("Correct!");
        } else {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public static void starter(String[] answersGame, String[] quests, String name) {
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        int counter = 0;
        while (counter < ROUNDS) {
            questViewer(quests[counter]);
            answerWaiter();
            answer = answerScanner.next();
            if (answer.equals(answersGame[counter])) {
                counter++;
                win(counter, name);
                if (counter == ROUNDS) {
                    answerScanner.close();
                }
            } else {
                wrongAnswer(answer, answersGame[counter], name);
                answerScanner.close();
                return;
            }
        }
    }

    private static void questViewer(String quest) {
        System.out.println("Question: " + quest);
    } //Вывод задания

    private static void wrongAnswer(String answer, String correctAnswer, String name) { //Вывод неверного ответа
        System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was "
                + "\'" + correctAnswer + "\'\n" + "Let's try again, " + name + "!");
    }

    private static void answerWaiter() {
        System.out.print("Your answer : ");
    }
}
