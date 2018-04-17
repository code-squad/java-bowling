package bowling.view;

import bowling.Frame;

/**
 * @author sangsik.kim
 */
public class Console {

    public static void main(String[] args) {
        String name = InputView.getPlayerName();

        Frame frame = Frame.initialFrame();
        Frame nextFrame = null;

        for (int i = 0; i < 9; i++) {
            while (frame.canThrowBowling()) {
                nextFrame = frame.shot(InputView.getDownPins(frame.current()));
                InputView.printScore();
                System.out.println(frame.getScore());
            }
            frame = nextFrame;
        }
    }

}
