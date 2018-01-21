package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NormalFrameTest {

  @Test
  public void 프레임_볼링_두번_굴리기() {
    NormalFrame frame = new NormalFrame();
    assertEquals(1, frame.roll(4));
    assertEquals(2, frame.roll(4));
  }
}
