package hexlet.code;

import hexlet.code.games.Progression;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    //Методы *.text() (Even.text() - пример) у каждой игры свой и определен в классе игры
    private static final int COUNTMAX = 3; //Максимальное число раундов
    private static final int EVENMETHOD = 2; //Назначения своего числа каждой игре
    private static final int CALCMETHOD = 3;
    private static final int GCDMETHOD = 4;
    private static final int PROGRESSIONMETHOD = 5;
    private static final int PRIMEMETHOD = 6;
    private static String[] arrayAnswer = new String[COUNTMAX];

    public static void win(int count) { //Метод отвечающий за вывод в случае победы в раунде и в игре
        if (count != COUNTMAX) {
            System.out.println("Correct!");
        } else {
            System.out.println("Congratulations, " + Cli.getName() + "!");
        }
    }

    public static void starter(int numberOfGame) { //Запуск каждого метода со нулевым счетчиком
        if (numberOfGame == EVENMETHOD) {
            setEvenMethod(0);
        }
        if (numberOfGame == CALCMETHOD) {
            setCalcMethod(0);
        }
        if (numberOfGame == GCDMETHOD) {
            setGcdMethod(0);
        }
        if (numberOfGame == PROGRESSIONMETHOD) {
            setProgressionMethod(0);
        }
        if (numberOfGame == PRIMEMETHOD) {
            setPrimeMethod(0);
        }
    }

    private static void questViewer(String quest) {
        System.out.println("Question: " + quest);
    } //Вывод задания

    private static void wrongAnswer(String answer, String correctAnswer) { //Вывод неверного ответа
        System.out.println("\'" + answer + "\'" + " is wrong answer ;(. Correct answer was "
                + "\'" + correctAnswer + "\'\n" + "Let's try again, " + Cli.getName() + "!");
    }

    private static void setEvenMethod(int counter) {
        Even.text();
        arrayAnswer = Even.even();
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        int[] arrayIntAnswer = Even.getQuest();
        for (; counter < COUNTMAX;) {
            questViewer(String.valueOf(arrayIntAnswer[counter]));
            answerWaiter();
            answer = answerScanner.nextLine();
            if (answer.equals(arrayAnswer[counter])) {
                counter++;
                win(counter);
                if (counter == COUNTMAX) {
                    answerScanner.close();
                }
            } else {
                wrongAnswer(answer, arrayAnswer[counter]);
                answerScanner.close();
                return;
            }
        }
    }

    private static void setCalcMethod(int counter) {
        int[] arrayAnswerCalc = Calc.calcing();
        String[] arrayQuestsCalc = Calc.getQuest();
        Calc.text();
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        for (; counter < COUNTMAX;) {
            questViewer(arrayQuestsCalc[counter]);
            answerWaiter();
            answer = answerScanner.next();
            if (Integer.parseInt(answer) == arrayAnswerCalc[counter]) {
                counter++;
                win(counter);
            } else {
                wrongAnswer(answer, String.valueOf(arrayAnswerCalc[counter]));
                return;
            }
        }
    }

    private static void setGcdMethod(int counter) {
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        int[] arrayAnswerGcd = GCD.gcdeing();
        GCD.text();
        for (; counter < COUNTMAX;) {
            questViewer(GCD.getQuests()[counter]);
            answerWaiter();
            answer = answerScanner.next();
            if (Integer.parseInt(answer) == arrayAnswerGcd[counter]) {
                counter++;
                win(counter);
            } else {
                wrongAnswer(answer, String.valueOf(arrayAnswerGcd[counter]));
                return;
            }
        }
    }

    private static void setProgressionMethod(int counter) {
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        Progression.text();
        for (; counter < COUNTMAX;) {
            System.out.print("Question: "); //В методе нет questViewer() , поэтому используется ручной вывод
            Progression.printArray();
            answerWaiter();
            answer = answerScanner.next();
            if (Integer.parseInt(answer) == Progression.getAnswer()) {
                counter++;
                win(counter);
            } else {
                wrongAnswer(answer, String.valueOf(Progression.getAnswer()));
                return;
            }
        }
    }

    private static void setPrimeMethod(int counter) {
        Scanner answerScanner = new Scanner(System.in);
        String answer;
        Prime.text();
        for (; counter < COUNTMAX;) {
            String correctAnswer = Prime.primer();
            questViewer(String.valueOf(Prime.getQuest()));
            answerWaiter();
            answer = answerScanner.next();
            if (answer.equals(correctAnswer)) {
                counter++;
                win(counter);
            } else {
                wrongAnswer(answer, correctAnswer);
                return;
            }
        }
    }

    private static void answerWaiter() {
        System.out.print("Your answer : ");
    }
}
