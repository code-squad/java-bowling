package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 하위 클래스에서 상속받아서 수행
public abstract class FrameTest {
    protected Frame frame;
    protected Frame nextFrame;
    protected Frame thirdFrame;

    protected abstract void initFrame();

    @Before
    public void setUp() {
        initFrame();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTryOverflow() {
        setTry(5);
        setTry(6);
    }

    @Test
    public void isStrike() {
        setTry(BowlingConstants.PIN_COUNT);

        assertEquals("  X  ", frame.showMessage());
    }

    @Test
    public void strikeScore() {
        for (int i=1; i<=BowlingConstants.PIN_COUNT; i++) {
            initFrame();
            setTry(BowlingConstants.PIN_COUNT);

            initNextNormalFrame();
            setNextFrameTry(i);

            System.out.println("i=" + i + ", frame=" + frame);
            System.out.println("i=" + i + ", frame=" + frame);
            initThirdNormalFrame();
            setThirdFrameTry(BowlingConstants.PIN_COUNT - i);

            assertEquals(" " + (BowlingConstants.PIN_COUNT * 2) + "  ", frame.showScore());
        }
    }

    @Test
    public void isSpare() {
        for (int i=1; i<BowlingConstants.PIN_COUNT; i++) {
            frame = new NormalFrame();
            setTry(i);
            setTry(BowlingConstants.PIN_COUNT - i);

            assertEquals(" " + i + "|/ ", frame.showMessage());
        }
    }

    @Test
    public void spareScore() {
        for (int i=1; i<BowlingConstants.PIN_COUNT; i++) {
            for (int j=1; j<BowlingConstants.PIN_COUNT; j++) {
                initFrame();
                setTry(i);
                setTry(BowlingConstants.PIN_COUNT - i);

                initNextNormalFrame();
                setNextFrameTry(j);

                if (!(frame instanceof LastFrame)) {
                    setNextFrameTry(BowlingConstants.PIN_COUNT - j);
                }

                assertEquals(" 1" + j + "  ", frame.showScore());
            }
        }
    }

    @Test
    public void isSpareWithGutter() {
        frame = new NormalFrame();
        setTry(0);
        setTry(BowlingConstants.PIN_COUNT);

        assertEquals(" -|/ ", frame.showMessage());
    }

    @Test
    public void notYet() {
        for (int i=1; i<BowlingConstants.PIN_COUNT; i++) {
            frame = new NormalFrame();
            setTry(i);

            assertEquals(" " + i + "   ", frame.showMessage());
        }
    }

    @Test
    public void isGutter() {
        setTry(0);

        assertEquals(" -   ", frame.showMessage());
    }

    @Test
    public void empty() {
        assertEquals("     ", frame.showMessage());
    }

    @Test
    public void normal() {
        for (int i=1; i<BowlingConstants.PIN_COUNT-1; i++) {
            initFrame();
            setTry(i);
            int secondDownCount = BowlingConstants.PIN_COUNT - i - 1;
            setTry(secondDownCount);

            assertEquals(" " + i + "|" + secondDownCount + " ", frame.showMessage());
        }
    }

    @Test
    public void normalScore() {
        for (int i=1; i<BowlingConstants.PIN_COUNT; i++) {
            for (int j=1; j<BowlingConstants.PIN_COUNT; j++) {
                initFrame();
                setTry(i);
                int secondDownCount = BowlingConstants.PIN_COUNT - i - 1;
                setTry(secondDownCount);

                initNextNormalFrame();
                if (!(frame instanceof LastFrame)) {
                    setNextFrameTry(j);
                    setNextFrameTry(BowlingConstants.PIN_COUNT - j);
                }

                assertEquals("  " + (BowlingConstants.PIN_COUNT -1) + "  ", frame.showScore());
            }
        }
    }

    @Test
    public void normalWithGutter() {
        for (int i=1; i<BowlingConstants.PIN_COUNT-1; i++) {
            frame = new NormalFrame();
            setTry(i);
            setTry(0);

            assertEquals(" " + i  + "|- ", frame.showMessage());
        }
    }

    protected void setTry(int i) {
        frame.setTry(new Try(i));
    }

    protected void initNextNormalFrame() {
        if (frame instanceof LastFrame) {
            return;
        }
        nextFrame = new NormalFrame();
        frame.setNextFrame(nextFrame);

    }

    protected void initThirdNormalFrame() {
        if (frame instanceof LastFrame) {
            return;
        }
        thirdFrame = new NormalFrame();
        nextFrame.setNextFrame(thirdFrame);
    }
    protected void setNextFrameTry(int i) {
        if (frame instanceof LastFrame) {
            frame.setTry(new Try(i));
            return;
        }
        nextFrame.setTry(new Try(i));
    }

    protected void setThirdFrameTry(int i) {
        if (frame instanceof LastFrame) {
            frame.setTry(new Try(i));
            return;
        }
        thirdFrame.setTry(new Try(i));
    }

    @Test
    public void normalWithGutter2() {
        for (int i=1; i<BowlingConstants.PIN_COUNT-1; i++) {
            frame = new NormalFrame();
            setTry(0);
            setTry(i);

            assertEquals(" -" + "|" + i  + " ", frame.showMessage());
        }
    }
}