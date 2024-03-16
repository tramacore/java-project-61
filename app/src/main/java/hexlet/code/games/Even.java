package hexlet.code.games;

public class Even {
    private static int quest;
    private static final int factor = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static int countRounds = 3; //Кол-во раундов - 3
    private static int[] arrayIntAnswer = new int[countRounds];

    public static String[] even() { /*При вызове метод создаст и заполнит 2 массива :
                                                                            1 с правильными ответами и 1 с числами*/
        String[] arrayAnswer = new String[countRounds];
        for (int i = 0; i < 3; i++) {
            quest = (int) (Math.random() * factor); //Создание числа
            arrayIntAnswer[i] = quest; //Передача созданного числа в переменную поля , для использования в Engine
            if (quest % 2 == 0) { //Если число четное
                arrayAnswer[i] = "yes"; //добавление правильного ответа в массив с правильными ответами
            } else if (quest % 2 != 0) { //Если число нечетное
                arrayAnswer[i] = "no"; //добавление правильного ответа в массив с правильными ответами
            }
        }
        return arrayAnswer;
    }

    public static void text() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public static int[] getQuest() {
        return arrayIntAnswer;
    }
}
