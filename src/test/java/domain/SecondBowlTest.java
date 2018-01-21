package domain;

import static org.junit.Assert.assertEquals;

import domain.state.BowlState;
import org.junit.Test;

public class SecondBowlTest {

  @Test
  public void 프레임의_두번째_시도_볼링핀_상태_확인() {
    FirstBowl firstBowl = new FirstBowl(7);
    SecondBowl secondBowl = new SecondBowl(3, firstBowl);
    assertEquals(BowlState.SPARE, secondBowl.getBowlState());

    secondBowl = new SecondBowl(2, firstBowl);
    assertEquals(BowlState.MISS, secondBowl.getBowlState());

    firstBowl = new FirstBowl(0);
    secondBowl = new SecondBowl(0, firstBowl);
    assertEquals(BowlState.GUTTER, secondBowl.getBowlState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void 프레임의_두번째_잘못된_시도() {
    FirstBowl firstBowl = new FirstBowl(10);
    new SecondBowl(3, firstBowl);
  }
}
