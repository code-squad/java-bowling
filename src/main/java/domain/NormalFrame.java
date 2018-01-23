package domain;

import domain.state.BowlState;

public class NormalFrame {

  private Bowl bowl;
  private SecondBowl secondBowl;

  public NormalFrame() {}

  public String roll(int fallenPins) {
    if (bowl == null) {
      bowl = new Bowl(fallenPins);
      return result(bowl);
    }

    secondBowl = new SecondBowl(fallenPins, bowl.getFallenBowlPin());
    return result(secondBowl);
  }

  public String result(Bowl bowl) {
    return bowl.toString();
  }

  public boolean isStrike() {
    return bowl.getBowlState() == BowlState.STRIKE;
  }
}
