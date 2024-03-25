package hexlet.code;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
public class Cli {

    public static void nameReciever() {
        Scanner sqName = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = sqName.nextLine();
        System.out.printf("Hello, %s!\n", StringUtils.capitalize(StringUtils.trim(userName)));
    }
}
