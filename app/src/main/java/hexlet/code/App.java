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
    private static final int NAMER = 1;

    public static void main(String[] args) {
        Menu.menu(); //Вывод меню
        Scanner scanAnswer = new Scanner(System.in);
        int answer = scanAnswer.nextInt(); //Выбор игры
        if (answer != 0) {
            Cli.nameReciever();
        } else { 
            return;
        }
        if (answer == EVENMETHOD) {
             Even.play();
        }
        if (answer == CALMETHOD) {
             Calc.play();
        }
        if (answer == GCDMETHOD) {
             GCD.play();
        }
        if (answer == PROGRESSIONMETHOD) {
             Progression.play();
        }
        if (answer == PRIMEMETHOD) {
             Prime.play();
        }
    }
}
