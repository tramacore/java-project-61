package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Menu.menu(); //Вывод меню
        Scanner scanAnswer = new Scanner(System.in);
        int answer = scanAnswer.nextInt(); //Выбор игры
        switch (answer) {
            case 1:
                Cli.nameReciever(); //На '1' работает только получение имени
                break;
            case 0: //При вводе '0' программа закрывается
                return;
            default:
                Cli.nameReciever();
                Engine.starter(answer); //При вводе любого другого числа запускается класс Engine
                break;
        }
    }
}
