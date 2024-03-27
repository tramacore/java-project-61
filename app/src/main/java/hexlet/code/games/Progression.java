package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int RULENUMBERMIN = 1;
    private static final int RULENUMBERMAX = 10;
    private static final int MINLENGTH = 5;
    private static final int MAXLENGTH = 12;
    public static String[] makeProgression(int firstValue, int rule, int length) {
        int[] arrayToShow = new int[length];
        String[] stringArray = new String[length];
        arrayToShow[0] = firstValue;
        for (int i = 1; i < length; i++) {
            arrayToShow[i] = arrayToShow[i - 1] + rule;
        }
        for (int i = 0; i < length; i++) {
            stringArray[i] = String.valueOf(arrayToShow[i]);
        }
        return stringArray;
    }

    public static String[][] hidder() { //Создаст массив , который будет прятать число в себе
        String[][] answer = new String[Engine.ROUNDS][2];
        String saver;
        for (int i = 0; i < Engine.ROUNDS; i++) {
            saver = "";
            int firstValue = Utils.generateNumber(0, Engine.MAXVALUE);
            int rule = Utils.generateNumber(RULENUMBERMIN, RULENUMBERMAX);
            int length = Utils.generateNumber(MINLENGTH, MAXLENGTH);
            String[] arrToHide = makeProgression(firstValue, rule, length);
            int hideNumber = Utils.generateNumber(0, length - 1);
            answer[i][1] = String.valueOf(arrToHide[hideNumber]); //Сохранение ответов
            arrToHide[hideNumber] = ".. ";
            for (int j = 0; j < arrToHide.length; j++) { //Цикл конкатенирует строку saver для передачи в нужном формате
                if (j == hideNumber) {
                    saver += ".. ";
                } else {
                    saver += arrToHide[j] + " ";
                }
            }
            answer[i][0] = saver; //Сохранение заданий
        }
        return answer;
    }

    public static void play() {
        String descriprion = "What number is missing in the progression?";
        Engine.starter(hidder(), descriprion);
    }
}
