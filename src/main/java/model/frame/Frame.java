package model.frame;

public interface Frame {

    void bowl(int number);
    Frame getNextFrame();

    static Frame of(int round) {
        if (round == 10) return new FinalFrame();
        return new NormalFrame(round);
    }
}
