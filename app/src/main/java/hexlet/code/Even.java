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
                if (quest % 2 == 0) { //Если число четное
                    if (answer.equals("yes")) { //и ввод отмечен как четное число
                        System.out.println("Correct!"); //вывод что ответ правильный
                        counter++; //увеличение счетчика
                    } else { //Если ввод отмечен неправильно (как нечетное число)
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'no'. Let's try again, "
                                + Cli.getName()); //вывод что ответ неправильный
                        return;
                    }
                } else if (quest % 2 != 0) { //Если число нечетное
                    if (answer.equals("no")) { //и ввод отмечен как нечетное число
                        System.out.println("Correct!"); //вывод что ответ правильный
                        counter++; //увеличение счетчика
                    } else {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'yes'. Let's try again, "
                                + Cli.getName()); //Если ввод отмечен неправильно (как нечетное число)
                        return;
                    }
                } else { //Если в ввод подается неолжидающаяся строка (отличная от "yes" и "no")
                    if (quest % 2 == 0) {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'yes'. Let's try again,"
                                + Cli.getName()); /*необходимо для определения какой ответ правильный
                                в случае если число четное */
                    } else {
                        System.out.println(answer + " is wrong answer ;(. Correct answer was 'no'. Let's try again,"
                                + Cli.getName()); /*необходимо для определения какой ответ правильный
                                в случае если число нечетное */
                    }
                    return;
                }
            } else { // При достижении счетчиком значения 3 - вывод о удачном завершении (победе) в игре
                System.out.println("Congratulations," + Cli.getName());
                isRight = true;
            }
        } while (!isRight);
    }
}
