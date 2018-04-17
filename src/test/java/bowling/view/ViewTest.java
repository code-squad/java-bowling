package bowling.view;

import bowling.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ViewTest {

    @Test
    public void normalFrameTest(){
        Frame frame1 = new Frame(Miss.of(Ball.of(4),Ball.of(5)));
        Frame frame2 = new Frame(Strike.of(Ball.of(10),null));
        Frame frame3 = new Frame(Miss.of(Ball.of(1),Ball.of(5)));
        Frame frame4 = new Frame(Spare.of(Ball.of(5),Ball.of(5)));

        List<Frame> frames = new ArrayList<>(Arrays.asList(frame1,frame2,frame3,frame4));
        View.printComplete(frames);
    }
}