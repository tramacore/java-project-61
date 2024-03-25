package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class App {
    private static final int EVENMETHOD = 2;
    private static final int CALMETHOD = 3;
    private static final int GCDMETHOD = 4;
    private static final int PROGRESSIONMETHOD = 5;
    private static final int PRIMEMETHOD = 6;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the game number and press Enter.\n" + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - GCD\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit"
                + "\nYour choice: ");
        int answer = scanner.nextInt(); //Выбор игры
        if (answer == EXIT) {
            return;
        }
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = scanner.next();
        System.out.printf("Hello, %s!\n", StringUtils.capitalize(StringUtils.trim(userName)));
        userName = StringUtils.capitalize(StringUtils.trim(userName));
        gameChooser(answer, userName);
    }
    private static void gameChooser(int digit, String userName) {
        if (digit == EVENMETHOD) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            Even.play(userName);
        }
        if (digit == CALMETHOD) {
            System.out.println("What is the result of the expression?");
            Calc.play(userName);
        }
        if (digit == GCDMETHOD) {
            System.out.println("Find the greatest common divisor of given numbers.");
            GCD.play(userName);
        }
        if (digit == PROGRESSIONMETHOD) {
            System.out.println("What number is missing in the progression?");
            Progression.play(userName);
        }
        if (digit == PRIMEMETHOD) {
            System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
            Prime.play(userName);
        }
    }
}
