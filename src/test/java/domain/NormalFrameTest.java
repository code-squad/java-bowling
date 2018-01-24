package domain;

import domain.frame.Frame;
import domain.frame.NormalFrame;
import domain.state.State;
import domain.state.Strike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NormalFrameTest {

  private Frame frame;

  @Before
  public void setUp() throws Exception {
    frame =  new NormalFrame();
  }

  @Test
  public void 프레임_스트라이크시_현재프레임_종료() throws Exception {
    frame.roll(new BowlPin(10));
    assertEquals(10, frame.getScore());
    assertEquals("X", frame.getSymbol());
    assertTrue(frame.isCurrentFrameEnd());
  }

  @Test
  public void 프레임_첫번째_시도_거터() throws Exception {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertEquals("-", frame.getSymbol());
    assertFalse(frame.isCurrentFrameEnd());
  }

  @Test
  public void 프레임_첫번째_두번째_시도_모두_거터() throws Exception {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertEquals("-", frame.getSymbol());
    assertFalse(frame.isCurrentFrameEnd());

    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertEquals("-", frame.getSymbol());
    assertTrue(frame.isCurrentFrameEnd());
  }

  @Test
  public void 프레임_첫번째_거터_두번째_스패어() throws Exception {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertEquals("-", frame.getSymbol());
    assertFalse(frame.isCurrentFrameEnd());

    frame.roll(new BowlPin(10));
    assertEquals(10, frame.getScore());
    assertEquals("/", frame.getSymbol());
    assertTrue(frame.isCurrentFrameEnd());
  }

  @Test
  public void 프레임_첫번째_거터_두번째_미스() throws Exception {
    frame.roll(new BowlPin(0));
    assertEquals(0, frame.getScore());
    assertEquals("-", frame.getSymbol());
    assertFalse(frame.isCurrentFrameEnd());

    frame.roll(new BowlPin(8));
    assertEquals(8, frame.getScore());
    //todo:optional 처리
    assertEquals(null, frame.getSymbol());
    assertTrue(frame.isCurrentFrameEnd());
  }

  @Test
  public void 프레임_첫번째_두번째_합친결과_미스() throws Exception {
    frame.roll(new BowlPin(7));
    assertEquals(7, frame.getScore());
    assertEquals(null, frame.getSymbol());
    assertFalse(frame.isCurrentFrameEnd());

    frame.roll(new BowlPin(2));
    assertEquals(9, frame.getScore());
    assertEquals(null, frame.getSymbol());
    assertTrue(frame.isCurrentFrameEnd());
  }
}
