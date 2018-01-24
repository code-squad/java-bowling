package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlPinTest {

  @Test(expected = IllegalArgumentException.class)
  public void 유효하지_않는값() throws Exception {
    new BowlPin(11);
  }

  @Test
  public void 넘어뜨린_볼링핀_갯수_상태확인() throws Exception {
    BowlPin bowlPin = new BowlPin(10);
    assertTrue(bowlPin.isStrike());

    bowlPin = new BowlPin(9);
    assertFalse(bowlPin.isStrike());

    bowlPin = new BowlPin(0);
    assertTrue(bowlPin.isGutter());

    bowlPin = new BowlPin(3);
    assertTrue(bowlPin.isSpare(new BowlPin(7)));
  }

  @Test
  public void 두개의_핀_더하기() throws Exception {
    BowlPin bowlPin = new BowlPin(3);
    assertEquals(10, bowlPin.sum(new BowlPin(7)));
    assertEquals(6, bowlPin.sum(new BowlPin(3)));
    assertEquals(9, bowlPin.sum(new BowlPin(6)));
  }
}
