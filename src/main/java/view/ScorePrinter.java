package view;

public class ScorePrinter {

    public static void printScores(Score score) {
        printScoreLabel();
        System.out.println(score);
    }

    public static void printScoreLabel() {
        StringBuilder builder = new StringBuilder();
        builder.append(ScoreMarker.markSeparator());
        builder.append("NAME");
        for (int number = 1; number < 11; number++) {
            builder.append(ScoreMarker.markSeparator());
            builder.append(Formatter.formatFrame(ScoreMarker.markFrameNumber(number)));
            builder.append(ScoreMarker.markSeparator());
        }
        System.out.println(ScoreMarker.markSeparator() + Formatter.formatFrame("NAME")
                + ScoreMarker.markSeparator());
    }
}
