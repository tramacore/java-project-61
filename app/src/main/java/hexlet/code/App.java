package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

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
        if (answer == EVENMETHOD) {
            Even.play();
        } else if (answer == CALMETHOD) {
            Calc.play();
        } else if (answer == GCDMETHOD) {
            GCD.play();
        } else if (answer == PROGRESSIONMETHOD) {
            Progression.play();
        } else if (answer == PRIMEMETHOD) {
            Prime.play();
        }
    }
}
