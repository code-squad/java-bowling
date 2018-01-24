package domain.frame;

import domain.score.FinalScore;
import domain.score.Pin;

class FinalFrame extends Frame {

    FinalFrame(Pin score) {
        super(new FinalScore(score));
    }

}
