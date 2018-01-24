package domain.frame;

import domain.frame.NormalFrame;

import java.util.ArrayList;
import java.util.List;

public class Frames {

  private List<NormalFrame> frames;

  public Frames() {
    this.frames = new ArrayList<>();
  }

  public void add(NormalFrame frame) {
    this.frames.add(frame);
  }

  public NormalFrame get(int round) {
    return frames.get(round - 1);
  }
}
