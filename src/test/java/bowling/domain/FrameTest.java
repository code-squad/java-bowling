package bowling.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// 하위 클래스에서 상속받아서 수행
public abstract class FrameTest {
    protected Frame frame;

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
    public void isSpare() {
        for (int i=1; i<BowlingConstants.PIN_COUNT; i++) {
            frame = new NormalFrame();
            setTry(i);
            setTry(BowlingConstants.PIN_COUNT - i);

            assertEquals(" " + i + "|/ ", frame.showMessage());
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
            frame = new NormalFrame();
            setTry(i);
            int secondDownCount = BowlingConstants.PIN_COUNT - i - 1;
            setTry(secondDownCount);

            assertEquals(" " + i + "|" + secondDownCount + " ", frame.showMessage());
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