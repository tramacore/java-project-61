package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static String[][] even() { /*При вызове метод создаст и заполнит 2 массива :
                                                                         1 с правильными ответами и 1 с числами*/
        final int maxvalue = 100;
        String[][] arrayAnswer = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int quest = Utils.generateNumber(0, maxvalue); //Создание числа
            arrayAnswer[i][0] = String.valueOf(quest);
            arrayAnswer[i][1] = (quest % 2 == 0) ? "yes" : "no";
        }
        return arrayAnswer;
    }

    public static void play() {
        String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.starter(even(), description);
    }
}
