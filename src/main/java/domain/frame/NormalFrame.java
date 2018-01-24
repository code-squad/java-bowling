package domain.frame;

import domain.score.NormalScore;
import domain.score.Pin;

class NormalFrame extends Frame {

    NormalFrame(Pin pin) {
        super(new NormalScore(pin));
    }

}
