package hexlet.code.games;

public class Progression {
    private static int answer; //Переменная , в которой будет правильный ответ
    private static final int FACTOR = 100; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 100
    private static final int FACTORTOLENGTH = 10; //т.к Math.random() генерирует число от 0 до 1 - то умножаем это число на 10
    //для создания массива до 10 символов
    public static int[] progress() {
        int generate = (int) (Math.random() * FACTORTOLENGTH); //Создание длины начального массива
        while (generate < 5) { // По условию массив должен быт не менее 5 чисел
            generate = (int) (Math.random() * FACTORTOLENGTH);
        }
        int[] arrayToShow = new int[generate]; //Создание самого массива , длиной заданной выше
        arrayToShow[0] = (int) (Math.random() * FACTOR); //Задание первого числа массива
        int x;
        do {
            x = (int) (Math.random() * FACTORTOLENGTH); //Задание числа , которое будет законом для прогрессии
        } while (x == 0); //оно не будет = 0 , тк в таком случае вся прогрессия равна первому числу
        for (int i = 1; i < generate; i++) {
            arrayToShow[i] = arrayToShow[i - 1] + x; /*Задание прогрессии , путем что следующий элемент
                                            массива = предыдущее + число-закон  */
        }
        return arrayToShow;
    }

    public static String[] hidder(int[] arr) { //СОздаст массив , который будет прятать число в себе
        int x = (int) (Math.random() * FACTOR); //Задает каким по порядку будет спрятанное число
        String[] arrToHide = new String[arr.length]; //Создание самого массива , длиной массива с метода progress
        while (x >= arr.length) {
            x = (int) (Math.random() * FACTOR); //Необходимо чтобы число не выходило за рамки длины массива
        }
        for (int i = 0; i < arr.length; i++) { //Цикл , который проходит по массиву и
            if (i == x) { //                                         в месте X (созданной и отрегулированнной выше)
                answer = arr[x];                   //подставит ..
                arrToHide[x] = "..";
            } else {
                arrToHide[i] = arr[i] + "";
            }
        }
        return arrToHide;
    }

    public static void printArray() {
        String[] arrayToPrint = hidder(progress());
        for (int i = 0; i < arrayToPrint.length; i++) {
            if (i != arrayToPrint.length - 1) {
                System.out.print(arrayToPrint[i] + " ");
            } else {
                System.out.print(arrayToPrint[i]);
            }
        }
    }

    public static int getAnswer() {
        return answer;
    }

    public static void text() {
        System.out.println("What number is missing in the progression?");
    }
}
