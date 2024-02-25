package hexlet.code;
import java.util.Scanner;
public class Cli {
    private static String name;
    public static void nameReciever() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        Scanner sqName = new Scanner(System.in);
        String userName = sqName.nextLine();
        name = userName;
        System.out.printf("\nHello %s!\n", userName);
    }

    public static String getName(){
        return name;
    }
}
