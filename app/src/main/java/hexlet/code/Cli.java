package hexlet.code;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
public class Cli {
    private static String name;
    public static void nameReciever() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        Scanner sqName = new Scanner(System.in);
        String userName = sqName.nextLine();
        name = StringUtils.capitalize(StringUtils.trim(userName));
        System.out.printf("\nHello %s!\n", name);
    }

    public static String getName() {
        return name;
    }
}
