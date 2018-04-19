package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LastFrameTest {

    private Frame lastFrame;

    @Before
    public void setUp() {
        lastFrame = LastFrame.of();
    }

    @Test
    public void frameEnd() {
        lastFrame.trying(3);
        assertThat(lastFrame.getTotalScore(), is(3));
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd2() {
        lastFrame.trying(3);
        lastFrame.trying(3);
        assertThat(lastFrame.getTotalScore(), is(6));
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void frameEnd3() {
        lastFrame.trying(4);
        lastFrame.trying(6);
        assertThat(lastFrame.getTotalScore(), is(10));
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd4() {
        lastFrame.trying(10);
        assertThat(lastFrame.getTotalScore(), is(10));
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd5() {
        lastFrame.trying(10);
        lastFrame.trying(1);
        assertThat(lastFrame.getTotalScore(), is(11));
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd6() {
        lastFrame.trying(4);
        lastFrame.trying(6);
        lastFrame.trying(6);
        assertThat(lastFrame.getTotalScore(), is(16));
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void frameEnd7() {
        lastFrame.trying(10);
        lastFrame.trying(6);
        lastFrame.trying(4);
        assertThat(lastFrame.getTotalScore(), is(20));
        assertThat(lastFrame.isFrameEnd(), is(true));
    }

    @Test
    public void frameEnd8() {
        lastFrame.trying(10);
        lastFrame.trying(10);
        assertThat(lastFrame.getTotalScore(), is(20));
        assertThat(lastFrame.isFrameEnd(), is(false));
    }

    @Test
    public void frameEnd9() {
        lastFrame.trying(10);
        lastFrame.trying(10);
        lastFrame.trying(10);
        assertThat(lastFrame.getTotalScore(), is(30));
        assertThat(lastFrame.isFrameEnd(), is(true));
    }


}
