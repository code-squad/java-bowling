package domain.frame.status;

public class Spare extends FrameStatus {
    private static Spare spare = new Spare();

    private Spare() {

    }

    public static Spare of() {
        return spare;
    }

    @Override
    public String convertScore(int score) {
        return "/";
    }
}
