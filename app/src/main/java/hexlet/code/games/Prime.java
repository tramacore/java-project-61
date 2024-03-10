package hexlet.code.games;

public class Prime {
    private static int quest;
    private static String answer;

    public static String primer() {
        int value = (int) (Math.random() * 100);
        quest = value;
        if (value < 2) {
            return "no";
        }
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    public static int getQuest() {
        return quest;
    }

    public static void text() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public static String getAnswer() {
        return answer;
    }
}
