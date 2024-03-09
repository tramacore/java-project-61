package hexlet.code;


import java.util.Arrays;

public class Even {
    static String correctAnswer;
    static int quest;
    private static int[] arrayIntAnswer = new int[3];
    public static String[] even() { /*При вызове метод создаст и заполнит 2 массива :
                                                                            1 с правильными ответами и 1 с числами*/
        String[] arrayAnswer = new String[3];
        for (int i = 0; i < 3; i++) {
            quest = (int) (Math.random() * 100); //Создание числа
            arrayIntAnswer[i] = quest; //Передача созданного числа в переменную поля , для использования в Engine
            if (quest % 2 == 0) { //Если число четное
                arrayAnswer[i] = "yes"; //добавление правильного ответа в массив с правильными ответами
            } else if (quest % 2 != 0) { //Если число нечетное
                arrayAnswer[i] = "no";//добавление правильного ответа в массив с правильными ответами
            }
        }
        return arrayAnswer;
    }

    public static void evenMessage() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public static int[] getQuest(){
        return arrayIntAnswer;
    }
}
