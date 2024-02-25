package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void even() {
        Cli.nameReciever();
        boolean isRight = false;
        int counter = 0;
        String answer;
        Scanner scanAnswer = new Scanner(System.in);
        do {
            int quest = (int) (Math.random() * 100);
            if (counter != 3) {
                System.out.println("Number: " + quest);
                answer = scanAnswer.nextLine();
                if (quest % 2 == 0) {
                    if (answer.equals("yes")) {
                        System.out.println("Correct!");
                        counter++;
                    } else {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'no'. Let's try again, "
                                + Cli.getName());
                        return;
                    }
                } else if (quest % 2 != 0) {
                    if (answer.equals("no")) {
                        System.out.println("Correct!");
                        counter++;
                    } else {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'yes'. Let's try again, "
                                + Cli.getName());
                        return;
                    }
                } else {
                    if (quest % 2 == 0) {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'yes'. Let's try again,"
                                + Cli.getName());
                    } else {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'no'. Let's try again,"
                                + Cli.getName());
                    }
                    return;
                }
            } else if (counter == 3) {
                System.out.println("Congratulations," + Cli.getName());
                isRight = true;
            }
        } while (!isRight);
    }
}
