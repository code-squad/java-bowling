package domain.frame.status;

public class Ing extends FrameStatus {
    private static Ing ing = new Ing();

    private Ing(){

    }

    public static Ing of() {
        return ing;
    }

    @Override
    public String convertScore(int score) {
        return String.valueOf(score);
    }

    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public boolean isBonus() {
        return false;
    }
}
