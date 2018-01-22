package model.frame;

import model.Ball;
import model.Score;

import java.util.ArrayList;
import java.util.List;

public class NormalFrame implements Frame{
    private int round;
    protected Score score;
    private List<Ball> bowls;
    private Frame nextFrame;

    public NormalFrame(int round) {
        this.bowls = new ArrayList<>();
        this.round = round;
        this.nextFrame = Frame.of(round + 1);
    }

    public void bowl(int number) {
        if(this.score != null) {
            nextFrame.bowl(number);
        }

        int size = bowls.size();

        if (size == 0) {
            if (number == 10) {
                bowls.add(new Ball(10));
                this.score = new Score(bowls);
                return;
            }
            bowls.add(new Ball(number));
            return;
        }

        if (size == 1) {
            bowls.add(new Ball(number));
            this.score = new Score(bowls);
        }
    }

    public Frame getNextFrame(){
        return nextFrame;
    }

    @Override
    public String toString() {
        if (score == null) {
            return " ";
        }
        return score.toString();
    }
}
