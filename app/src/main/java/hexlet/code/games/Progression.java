package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int RULENUMBERMIN = 1;
    private static final int RULENUMBERMAX = 10;
    private static final int MINLENGTH = 5;
    private static final int MAXLENGTH = 12;
    public static String[] makeProgression(int firstValue, int rule, int length) {
        String[] stringArray = new String[length];
        for (int i = 0; i < length; i += 1) {
            stringArray[i] = Integer.toString(firstValue + i * rule);
        }
        return stringArray;
    }

    public static String[][] generateRoundData() { //Создаст массив , который будет прятать число в себе
        String[][] answer = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstValue = Utils.generateNumber(0, Engine.MAXVALUE);
            int rule = Utils.generateNumber(RULENUMBERMIN, RULENUMBERMAX);
            int length = Utils.generateNumber(MINLENGTH, MAXLENGTH);
            String[] arrToHide = makeProgression(firstValue, rule, length);
            int hideNumber = Utils.generateNumber(0, length - 1);
            answer[i][1] = String.valueOf(arrToHide[hideNumber]); //Сохранение ответов
            arrToHide[hideNumber] = "..";
            String question = String.join(" ", arrToHide);
            answer[i][0] = question; //Сохранение заданий
        }
        return answer;
    }

    public static void play() {
        String descriprion = "What number is missing in the progression?";
        Engine.starter(generateRoundData(), descriprion);
    }
}
