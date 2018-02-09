package bowling.domain;

import org.junit.Test;

public class NormalFrameTest extends FrameTest {
    @Override
    protected void initFrame() {
        super.frame = new NormalFrame();
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtStrike() {
        setTry(10);
        setTry(5);
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtSpare() {
        setTry(4);
        setTry(6);
        setTry(1);
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtNormal() {
        setTry(4);
        setTry(5);
        setTry(1);
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtGutter() {
        setTry(0);
        setTry(5);
        setTry(1);
    }
}