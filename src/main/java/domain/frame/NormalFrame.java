package domain.frame;

import domain.score.Pin;
import domain.score.Score;

class NormalFrame extends Frame {

    NormalFrame(Pin pin) {
        super(new Score(pin));
    }

}
