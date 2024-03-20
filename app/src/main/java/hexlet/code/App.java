package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Menu.menu(); //Вывод меню
        Scanner scanAnswer = new Scanner(System.in);
        int answer = scanAnswer.nextInt(); //Выбор игры
        if (answer != 0) {
            Cli.nameReciever();
        }
        switch (answer) {
            case 1:
                return;
            case 0: //При вводе '0' программа закрывается
                return;
            case 2:
                Even.play();
                return;
            case 3:
                Calc.play();
                return;
            case 4:
                GCD.play();
                return;
            case 5:
                Progression.play();
                return;
            case 6:
                Prime.play();
            default:
                break;
        }
    }
}
