package hexlet.code;
import java.util.Scanner;
public class Cli {

    public static void nameReciever() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = scanner.nextLine();
        System.out.printf("Hello, %s!\n", userName);
    }
}
