package hexlet.code;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
public class Cli {
    private static String username;
    public static void nameReciever() {
        Scanner sqName = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String userName = sqName.nextLine();
        System.out.printf("Hello, %s!\n", StringUtils.capitalize(StringUtils.trim(userName)));
        setName(StringUtils.capitalize(StringUtils.trim(userName)));
    }

    public static String getName() {
        return username;
    }
    private static void setName(String name) {
        username = name;
    }
}
 //Передавать данные через статическое поле - ненадежно.
 // Допустим данные в поле не были записаны, а кто-то захочет их там прочитать.
 //Значение переменной в таком случае будет либо неверным либо вообще null и произойдёт ошибка.
 //Следует пользоваться только локальными переменными и передавать их как аргумент функции.
 //В данном случае уместно где необходимо имя пользователя, там его и спрашивать.

  /* ↑Это комментарий к предыдущей версии проекта.↑ Я понял что лучше пользоваться локальными переменными
  * но как в таком случае мне передать имя пользователя в другие методы? Он же удалит эту переменную
  * после выполнения метода и мне придется еще раз через сканнер спрашивать имя.Это же приватное
  * поле и изменить за пределами класса его нельзя.Доступен только геттер .*/
