package hexlet.code.games;

public class Calc {
    public static int countRounds = 3; //Кол-во раундов - 3
    private static String[] questSaver = new String[countRounds];

    public static int[] calcing() {
        int[] correctAnswers = new int[countRounds]; //Создание массива , в котором будут правильные ответы(на 3 раунда)
        int factor = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
        for (int i = 0; i < countRounds; i++) {
            int firstValue = (int) (Math.random() * factor);
            int secondValue = (int) (Math.random() * factor);
            double operator = Math.random(); //Генерирует число для постановки оператора
            double theThirdPart = 0.33; //Т.к операторов 3 - то вероятность выбора одного из них - 1 / 3
            double twoThirds = 0.66; //Вероятность выбора ТРЕТЬЕГО оператора
            //Вероятность второго не нужна - т.к она больше первого , но меньше второго
            if (operator <= theThirdPart) { //Если число меньше трети - то оператор - сложение
                correctAnswers[i] = firstValue + secondValue;
                questSaver[i] = firstValue + " + " + secondValue;
            } else if (operator > theThirdPart && operator < twoThirds) {
                correctAnswers[i] = firstValue * secondValue;
                questSaver[i] = firstValue + " * " + secondValue;
            } else if (operator > twoThirds) {
                correctAnswers[i] = firstValue - secondValue;
                questSaver[i] = firstValue + " - " + secondValue;
            }
        }
        return correctAnswers;
    }

    public static String[] getQuest() {
        return questSaver;
    }

    public static void text() {
        System.out.println("What is the result of the expression?");
    }
}
