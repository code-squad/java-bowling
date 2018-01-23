package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest extends FrameDefaultTest {
    @Before
    public void setUp() {
        super.frame = new Frame();
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