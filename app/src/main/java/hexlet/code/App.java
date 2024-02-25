package hexlet.code;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Menu.menu();
        Scanner scanAnswer = new Scanner(System.in);
        boolean isRigth = false;
        int answer = 0;
        boolean errorMessageDisplayed = false;
        do {
            if (errorMessageDisplayed == true) {
                System.out.println("You must to send me a digit");
                scanAnswer.nextLine();
            }
            try {
                answer = scanAnswer.nextInt();
                isRigth = true;
                errorMessageDisplayed = false;
            } catch (InputMismatchException e) {
                errorMessageDisplayed = true;
            }
        } while (!isRigth);
        switch (answer) {
            case 1:
                Cli.nameReciever();
                break;
            case 2:
                Even.even();
                break;
            default:
                return;
        }
    }
}
