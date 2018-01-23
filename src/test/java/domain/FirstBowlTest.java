package domain;

import static org.junit.Assert.assertEquals;

import domain.state.BowlState;
import org.junit.Test;

public class FirstBowlTest {

  @Test
  public void 프레임의_첫번째_시도_넘어뜨린_볼링핀_상태_확인() {
    Bowl bowl = new Bowl(10);
    assertEquals(new BowlPin(10), bowl.getFallenBowlPin());
    assertEquals(BowlState.STRIKE, bowl.getBowlState());

    bowl = new Bowl(0);
    assertEquals(BowlState.GUTTER, bowl.getBowlState());

    bowl = new Bowl(7);
    assertEquals(new BowlPin(7), bowl.getFallenBowlPin());
    assertEquals(null, bowl.getBowlState());
  }
}
