package domain;

import static org.junit.Assert.assertEquals;

import domain.state.BowlState;
import org.junit.Test;

public class FirstBowlTest {

  @Test
  public void 프레임의_첫번째_시도_넘어뜨린_볼링핀_상태_확인() {
    FirstBowl bowl = new FirstBowl(10);
    assertEquals(10, bowl.getFallenBowlPin());
    assertEquals(BowlState.STRIKE, bowl.getBowlState());

    bowl = new FirstBowl(7);
    assertEquals(7, bowl.getFallenBowlPin());
    assertEquals(null, bowl.getBowlState());
  }
}
