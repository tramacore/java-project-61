package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final int EVENMETHOD = 2;
    private static int quest;
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static final int COUNTROUNDS = 3; //Кол-во раундов - 3
    private static String[] arrayQuests = new String[COUNTROUNDS];

    public static String[] even() { /*При вызове метод создаст и заполнит 2 массива :
                                                                            1 с правильными ответами и 1 с числами*/
        String[] arrayAnswer = new String[COUNTROUNDS];
        for (int i = 0; i < COUNTROUNDS; i++) {
            quest = (int) (Math.random() * FACTOR); //Создание числа
            arrayQuests[i] = String.valueOf(quest); //Передача созданного числа в переменную поля , для использования в Engine
            if (quest % 2 == 0) { //Если число четное
                arrayAnswer[i] = "yes"; //добавление правильного ответа в массив с правильными ответами
            } else if (quest % 2 != 0) { //Если число нечетное
                arrayAnswer[i] = "no"; //добавление правильного ответа в массив с правильными ответами
            }
        }
        return arrayAnswer;
    }

    public static String[] getQuest() {
        return arrayQuests;
    }
    public static void play() {
        Engine.starter(EVENMETHOD, even(), getQuest());
    }
}
