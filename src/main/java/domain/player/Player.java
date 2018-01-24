package domain.player;

import domain.FrameResult;
import domain.FrameResults;

public class Player {

  private String name;
  private FrameResults results;

  public Player(String name, FrameResults results) {
    this.name = name;
    this.results = results;
  }

  public String getName() {
    return name;
  }

  public FrameResults getFrameResults() {
    return results;
  }

  public void setResult(int round, FrameResult result) {
    results.add(round, result);
  }
}
