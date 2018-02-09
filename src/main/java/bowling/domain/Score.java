package bowling.domain;

public class Score {
    public static String show(int score) {
        if (score == 0) {
            return "     ";
        }

        return String.format(" %2d  ", score);
    }
}
