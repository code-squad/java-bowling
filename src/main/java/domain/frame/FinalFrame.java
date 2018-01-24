package domain.frame;

import domain.score.Pin;
import domain.score.Score;

class FinalFrame extends Frame {

    FinalFrame(Pin score) {
        super(new Score(score));
    }

}
