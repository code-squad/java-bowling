package domain;

import domain.frame.Frame;
import domain.frame.NormalFrame;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class NormalFrameTest {

  private Frame frame;

  @Before
  public void setUp() {
    frame =  new NormalFrame();
  }

  @Test
  public void 프레임_10_스트라이크() {
    frame.roll(new BowlPin(10));
    프레임_결과_조회(10, true, "X");
  }

  @Test
  public void 프레임_0_거터() {
    frame.roll(new BowlPin(0));
    프레임_결과_조회(0, false, "-");
  }

  @Test
  public void 프레임_0_0_거터() {
    frame.roll(new BowlPin(0));
    프레임_결과_조회(0, false, "-");

    frame.roll(new BowlPin(0));
    프레임_결과_조회(0, true, "-|-");
  }

  @Test
  public void 프레임_0_10_스패어() {
    frame.roll(new BowlPin(0));
    프레임_결과_조회(0, false, "-");

    frame.roll(new BowlPin(10));
    프레임_결과_조회(10, true, "-|/");
  }

  @Test
  public void 프레임_0_거터_8_미스() {
    frame.roll(new BowlPin(0));
    프레임_결과_조회(0, false, "-");

    frame.roll(new BowlPin(8));
    프레임_결과_조회(8, true, "-|8");
  }

  @Test
  public void 프레임_5_0_거터() {
    frame.roll(new BowlPin(5));
    프레임_결과_조회(5, false, "5");

    frame.roll(new BowlPin(0));
    프레임_결과_조회(5, true, "5|-");
  }

  @Test
  public void 프레임_7_2_미스() {
    frame.roll(new BowlPin(7));
    프레임_결과_조회(7, false, "7");

    frame.roll(new BowlPin(2));
    프레임_결과_조회(9, true, "7|2");
  }

  @Test
  public void 프레임_3_7_스페어() {
    frame.roll(new BowlPin(3));
    프레임_결과_조회(3, false, "3");

    frame.roll(new BowlPin(7));
    프레임_결과_조회(10, true, "3|/");
  }

  private void 프레임_결과_조회(int score, boolean frameEnd, String result) {
    assertThat(frame.getScore(), equalTo(score));
    assertThat(frame.isFrameEnd(), equalTo(frameEnd));
    assertThat(frame.getResult(), equalTo(result));
  }
}
