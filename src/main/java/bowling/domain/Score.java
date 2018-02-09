package bowling.domain;

public class Score {
    public static String show(int score) {
        if (score == 0) {
            return "     ";
        }

        if (score > 10) {
            return "  " + score + " ";
        }

        return "  " + score + "  ";
    }
}
