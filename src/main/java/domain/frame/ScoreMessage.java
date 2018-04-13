package domain.frame;

public enum ScoreMessage {
    TEN("X"),
    SPARE("/"),
    ZERO("-"),
    MODIFIER("|");

    private String message;

    ScoreMessage(String message) {
        this.message = message;
    }

    public static String convertMessage(int score) {
        if (score == 10) {
            return TEN.message;
        }

        if (score == 0) {
            return ZERO.message;
        }
        return String.valueOf(score);
    }

    public static String getMessage(ScoreMessage scoreMessage) {
        return scoreMessage.message;
    }
}
