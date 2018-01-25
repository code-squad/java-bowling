package domain;

import domain.frame.FinalFrame;
import domain.frame.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FinalFrameTest {
  private Frame frame;

  @Before
  public void setUp() {
    frame = new FinalFrame();
  }

  @Test
  public void 프레임_10_보너스_10_보너스_10() throws Exception {
    frame.roll(new BowlPin(10));
    프레임_결과_조회(10, false, "X");

    frame.roll(new BowlPin(10));
    프레임_결과_조회(20, false, "X|X");

    frame.roll(new BowlPin(10));
    프레임_결과_조회(30, true, "X|X|X");
  }

  @Test
  public void 프레임_7_2_미스() {
    frame.roll(new BowlPin(7));
    프레임_결과_조회(7, false, "7");

    frame.roll(new BowlPin(2));
    프레임_결과_조회(9, true, "7|2");
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

  private void 프레임_결과_조회(int score, boolean frameEnd, String result) {
    assertThat(frame.getScore(), equalTo(score));
    assertThat(frame.isFrameEnd(), equalTo(frameEnd));
    assertThat(frame.getResult(), equalTo(result));
  }
}
