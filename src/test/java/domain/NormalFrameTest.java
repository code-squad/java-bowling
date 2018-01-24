package domain;

import domain.frame.Frame;
import domain.frame.NormalFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NormalFrameTest {

  private Frame frame;

  @Before
  public void setUp() {
    frame =  new NormalFrame();
  }

  @Test
  public void 프레임_스트라이크_현재프레임_종료() {
    frame.roll(new BowlPin(10));
    assertEquals(10, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("X", frame.getResult());
  }

  @Test
  public void 프레임_첫번째_시도_거터() {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("-", frame.getResult());
  }

  @Test
  public void 프레임_첫번째_두번째_시도_모두_거터() {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("-", frame.getResult());

    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("-|-", frame.getResult());
  }

  @Test
  public void 프레임_첫번째_거터_두번째_스패어() {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("-", frame.getResult());

    frame.roll(new BowlPin(10));
    assertEquals(10, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("-|/", frame.getResult());
  }

  @Test
  public void 프레임_첫번째_거터_두번째_미스() {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("-", frame.getResult());

    frame.roll(new BowlPin(8));
    assertEquals(8, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("-|8", frame.getResult());
  }

  @Test
  public void 프레임_첫번째_NoneState_두번째_거터() {
    frame.roll(new BowlPin(5));
    assertEquals(5, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("5", frame.getResult());

    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("5|-", frame.getResult());
  }

  @Test
  public void 프레임_첫번째_두번째_합친결과_미스() {
    frame.roll(new BowlPin(7));
    assertEquals(7, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("7", frame.getResult());

    frame.roll(new BowlPin(2));
    assertEquals(9, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("7|2", frame.getResult());
  }

  @Test
  public void 프레임_스페어_처리() {
    frame.roll(new BowlPin(3));
    assertEquals(3, frame.getScore());
    assertFalse(frame.isFrameEnd());
    assertEquals("3", frame.getResult());

    frame.roll(new BowlPin(7));
    assertEquals(10, frame.getScore());
    assertTrue(frame.isFrameEnd());
    assertEquals("3|/", frame.getResult());
  }
}
