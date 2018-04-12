package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class NomalFrame extends Frame {

    public NomalFrame next() {
        return new NomalFrame();
    }
}
