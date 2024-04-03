package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static String[] makeProgression(int firstValue, int rule, int length) {
        String[] stringArray = new String[length];
        for (int i = 0; i < length; i += 1) {
            stringArray[i] = Integer.toString(firstValue + i * rule);
        }
        return stringArray;
    }

    public static String[][] generateRoundData() { //Создаст массив , который будет прятать число в себе
        final int rulenumbermin = 1;
        final int rulenumbermax = 10;
        final int minlength = 5;
        final int maxlength = 12;
        final int maxvalue = 100;
        String[][] answer = new String[Engine.ROUNDS][2];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstValue = Utils.generateNumber(0, maxvalue);
            int rule = Utils.generateNumber(rulenumbermin, rulenumbermax);
            int length = Utils.generateNumber(minlength, maxlength);
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
