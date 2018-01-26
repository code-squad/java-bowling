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
  public void 프레임_10_보너스_7_3_스페어() {
    frame.roll(new BowlPin(10));
    프레임_결과_조회(10, false, "X");

    frame.roll(new BowlPin(7));
    프레임_결과_조회(17, false, "X|7");

    frame.roll(new BowlPin(3));
    프레임_결과_조회(20, true, "X|7|/");
  }

  @Test
  public void 프레임_10_보너스_7_2() {
    frame.roll(new BowlPin(10));
    프레임_결과_조회(10, false, "X");

    frame.roll(new BowlPin(7));
    프레임_결과_조회(17, false, "X|7");

    frame.roll(new BowlPin(2));
    프레임_결과_조회(19,true, "X|7|2");
  }

  @Test
  public void 프레임_8_2_스페어_보너스_10() {
    frame.roll(new BowlPin(8));
    프레임_결과_조회(8, false, "8");

    frame.roll(new BowlPin(2));
    프레임_결과_조회(10, false, "8|/");

    frame.roll(new BowlPin(10));
    프레임_결과_조회(20, true, "8|/|X");
  }

  @Test
  public void 프레임_8_2_스페어_보너스_8() {
    frame.roll(new BowlPin(8));
    프레임_결과_조회(8, false, "8");

    frame.roll(new BowlPin(2));
    프레임_결과_조회(10, false, "8|/");

    frame.roll(new BowlPin(8));
    프레임_결과_조회(18, true, "8|/|8");
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
