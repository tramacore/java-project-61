package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static String[][] even() { /*При вызове метод создаст и заполнит 2 массива :
                                                                            1 с правильными ответами и 1 с числами*/
        String[][] arrayAnswer = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int quest = Utils.generateNumber(0, 100); //Создание числа
            arrayAnswer[i][0] = String.valueOf(quest);
            if (quest % 2 == 0) { //Если число четное
                arrayAnswer[i][1] = "yes"; //добавление правильного ответа в массив с правильными ответами
            } else { //Если число нечетное
                arrayAnswer[i][1] = "no"; //добавление правильного ответа в массив с правильными ответами
            }
        }
        return arrayAnswer;
    }

    public static void play() {
        String description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.starter(even(), description);
    }
}
