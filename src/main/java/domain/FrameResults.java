package domain;

import java.util.List;

public class FrameResults {

  List<FrameResult> results;

  public void add(Bowl bowl) {
    results.add(new FrameResult(bowl));
  }

  public void add(int round, SecondBowl secondBowl) {
    FrameResult frameResult = get(round);
    frameResult.setSecondBowl(secondBowl);
  }

  public FrameResult get(int round) {
    return results.get(round - 1);
  }

  // frame의 결과 저장 1 - X, 2 - 7|/
  //
  public String getA(int i) {
    return "X";
  }
}
