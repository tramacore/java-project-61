package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {

    public static String[][] calcing() {
        String[][] correctAnswers = new String[Engine.ROUNDS][2]; //Создание массива ,
        //в котором будут правильные ответы(на 3 раунда)
        for (int i = 0; i < Engine.ROUNDS; i++) {
            final char[] operators = {'+', '-', '*'};
            int firstValue = Utils.generateNumber(0, Engine.MAXVALUE);
            int secondValue = Utils.generateNumber(0, Engine.MAXVALUE);
            var indexOperator = Utils.generateNumber(0, operators.length - 1);

            var operator = operators[indexOperator];

            correctAnswers[i][1] = String.valueOf(operating(operator, firstValue, secondValue));
            correctAnswers[i][0] = firstValue + " " + operator + " " + secondValue;
        }
        return correctAnswers;
    }

    private static int operating(char factor, int firstValue, int secondValue) {
        if (factor == '+') { //Если число меньше трети - то оператор - сложение
            return firstValue + secondValue;
        } else if (factor == '*') {
            return firstValue * secondValue;
        } else {
            return firstValue - secondValue;
        }
    }

    public static void play() {
        String description = "What is the result of the expression?";
        Engine.starter(calcing(), description);
    }
}
