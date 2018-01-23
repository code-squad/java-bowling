import domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BowlingWorker {

  private Frames frames;

  public void createBowlGame(String name) {
    this.frames = new Frames();
    IntStream.rangeClosed(1, 10).forEach(i -> {
      frames.add(new NormalFrame());
    });
  }

  public FrameResults roll(int round, int pins) {
    NormalFrame frame = frames.get(round);
    //Bowl bowl = frame.roll(pins);
    return new FrameResults();
  }

  public boolean isStrike(int round) {
    return frames.isCompleted(round);
  }
}
