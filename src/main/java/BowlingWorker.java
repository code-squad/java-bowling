import domain.*;
import domain.frame.Frames;
import domain.frame.NormalFrame;

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
}
