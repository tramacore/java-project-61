package hexlet.code.games;
import java.lang.Math;
public class Calc implements GAMESET{
    private static String[] questSaver = new String[3];
    public static int[] calcing() {
        int[] correctAnswers = new int[3];
        for (int i = 0; i < 3; i++) {
           int firstValue = (int)(Math.random() * 100);
           int secondValue = (int)(Math.random() * 100);
           double operator = Math.random();
           if(operator <= 0.33) {
               correctAnswers[i] = firstValue + secondValue;
               questSaver[i] = firstValue + "+" + secondValue;
           }else if (operator > 0.33 && operator < 0.66) {
               correctAnswers[i] = firstValue * secondValue;
               questSaver[i] = firstValue + "*" + secondValue;
           } else if (operator > 0.66) {
               correctAnswers[i] = firstValue - secondValue;
               questSaver[i] = firstValue + "-" + secondValue;
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
