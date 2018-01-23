package domain;

import static org.junit.Assert.assertEquals;

import domain.state.BowlState;
import org.junit.Test;

public class SecondBowlTest {

  @Test
  public void 프레임의_두번째_시도_볼링핀_상태_확인() {
    Bowl bowl = new Bowl(7);
    SecondBowl secondBowl = new SecondBowl(3, bowl.getFallenBowlPin());
    assertEquals(BowlState.SPARE, secondBowl.getBowlState());

//    secondBowl = new SecondBowl(2, bowl.getFallenBowlPin());
//    assertEquals(BowlState.MISS, secondBowl.getBowlState());

    secondBowl = new SecondBowl(0, bowl.getFallenBowlPin());
    assertEquals(BowlState.GUTTER, secondBowl.getBowlState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void 프레임의_두번째_잘못된_시도() {
    Bowl bowl = new Bowl(10);
    new SecondBowl(3, bowl.getFallenBowlPin());
  }
}
