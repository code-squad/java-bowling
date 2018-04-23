package frame;

import status.State;

public class FrameManager {
//    private Frame frame = new Frame();
//
//    public Frame onFrame(int i) {
//        frame.shoot(i);
//        if (frame.finishFrame()) {
//            return frame;
//        }
//        return frame;
//    }

    private Frame2 frame2 = new Frame2();
    private State state;
    public State onFrame(int i) {
        state = frame2.bowl(i);
        if (state.isFinish())
            return state;
        return state;
    }
}
