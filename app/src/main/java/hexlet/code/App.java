package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Menu.menu();
        Scanner scanAnswer = new Scanner(System.in);
        int answer = scanAnswer.nextInt();
        switch (answer) {
            case 0:
                return;
            case 1:
                Cli.nameReciever();
                break;
            case 2:
                Even.even();
                break;
            default:
                break;
        }
    }
}
