package domain;

import java.util.HashMap;
import java.util.Map;

public class FrameResults {

  Map<Integer, FrameResult> results;

  public FrameResults() {
    this.results = new HashMap<>();
  }

  public void add(Integer round, FrameResult result) {
    results.put(round, result);
  }

  public FrameResult get(int round) {
    return results.get(round);
  }

  public Map<Integer, FrameResult> getResults() {
    return results;
  }
}
