package domain;

public class NormalFrame {

  private int frameSeqNo;
  private FirstBowl firstBowl;
  private SecondBowl secondBowl;

  public NormalFrame() {
    frameSeqNo = 1;
  }

  public int roll(int fallenPins) {
    if (isFirstBowl()) {
      firstBowl = new FirstBowl(fallenPins);
      return frameSeqNo++;
    }

    secondBowl = new SecondBowl(fallenPins, firstBowl);
    return frameSeqNo;
  }

  private boolean isFirstBowl() {
    return frameSeqNo == 1;
  }
}
