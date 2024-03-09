package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;
import hexlet.code.Engine;

public class App {
    public static void main(String[] args) {
        Menu.menu();
        Scanner scanAnswer = new Scanner(System.in);
        boolean isRigth = false;
        int answer = scanAnswer.nextInt();
        switch (answer) {
            case 1:
                Cli.nameReciever();
                break;
            case 0:
                return;
            default:
                Engine.starter(answer);
                break;
        }
    }
}
