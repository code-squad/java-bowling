package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FrameDataTest {

    private FrameData frameData;

    @Before
    public void setup() {
        frameData = new FrameData();
    }

    @Test
    public void playNormalFrameTest() {
        frameData.play(4);
        frameData.play(3);

        frameData.play(10);

        frameData.play(5);
        frameData.play(2);

        frameData.play(3);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 3);

        assertEquals(frames.get(0).totalScore(), 7);
        assertEquals(frames.get(1).totalScore(), 24);
        assertEquals(frames.get(2).totalScore(), 31);
    }

    @Test
    public void 연속_스트라이크_테스트() {
        frameData.play(10);

        frameData.play(10);

        frameData.play(10);

        frameData.play(3);
        frameData.play(5);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 4);

        assertEquals(frames.get(0).totalScore(), 30);
        assertEquals(frames.get(1).totalScore(), 53);
        assertEquals(frames.get(2).totalScore(), 71);
        assertEquals(frames.get(3).totalScore(), 79);
    }

    @Test
    public void 스페어_테스트() {
        frameData.play(1);
        frameData.play(9);

        frameData.play(5);
        frameData.play(5);

        frameData.play(1);
        frameData.play(3);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 3);

        assertEquals(frames.get(0).totalScore(), 15);
        assertEquals(frames.get(1).totalScore(), 26);
        assertEquals(frames.get(2).totalScore(), 30);
    }

    @Test
    public void 마지막_프레임_미스_테스트() {
        for (int i = 0; i < 9; i++) {
            frameData.play(0);
            frameData.play(0);
        }
        assertEquals(frameData.playLastFrame(1), false);
        assertEquals(frameData.playLastFrame(1), true);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 10);

        assertEquals(frames.get(9).totalScore(), 2);
    }

    @Test
    public void 마지막_프레임_스페어_테스트() {
        for (int i = 0; i < 9; i++) {
            frameData.play(0);
            frameData.play(0);
        }
        assertEquals(frameData.playLastFrame(1), false);
        assertEquals(frameData.playLastFrame(9), false);
        assertEquals(frameData.playLastFrame(9), true);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 10);

        assertEquals(frames.get(9).totalScore(), 19);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 마지막_프레임_스트라이크_Exception_테스트() {
        for (int i = 0; i < 9; i++) {
            frameData.play(0);
            frameData.play(0);
        }
        assertEquals(frameData.playLastFrame(10), false);
        assertEquals(frameData.playLastFrame(9), false);
        assertEquals(frameData.playLastFrame(9), true);
    }

    @Test
    public void 마지막_프레임_스트라이크_테스트() {
        for (int i = 0; i < 9; i++) {
            frameData.play(0);
            frameData.play(0);
        }
        assertEquals(frameData.playLastFrame(10), false);
        assertEquals(frameData.playLastFrame(9), false);
        assertEquals(frameData.playLastFrame(1), true);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 10);

        assertEquals(frames.get(9).totalScore(), 20);
    }

    @Test
    public void 마지막_프레임_스트라이크_다음10핀_테스트() {
        for (int i = 0; i < 9; i++) {
            frameData.play(0);
            frameData.play(0);
        }
        assertEquals(frameData.playLastFrame(10), false);
        assertEquals(frameData.playLastFrame(10), false);
        assertEquals(frameData.playLastFrame(5), true);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 10);

        assertEquals(frames.get(9).totalScore(), 25);
    }

    @Test
    public void 아홉번째프레임_스트라이크_마지막프레임_점수_테스트() {
        for (int i = 0; i < 8; i++) {
            frameData.play(0);
            frameData.play(0);
        }
        frameData.play(10);
        assertEquals(frameData.playLastFrame(10), false);
        assertEquals(frameData.playLastFrame(10), false);
        assertEquals(frameData.playLastFrame(2), true);

        List<Frame> frames = frameData.getFrames();
        assertEquals(frames.size(), 10);

        assertEquals(frames.get(8).totalScore(), 30);
        assertEquals(frames.get(9).totalScore(), 52);
    }
}