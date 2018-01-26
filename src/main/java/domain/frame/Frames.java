package domain.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {

  private List<Frame> frames;

  public Frames() {
    this.frames = new ArrayList<>();
  }

  public void add(Frame frame) {
    this.frames.add(frame);
  }

  public Frame get(int round) {
    return frames.get(round - 1);
  }

  public boolean isFrameEnd(int round) {
    return get(round).isFrameEnd();
  }

  public boolean isFrameExisted(int round) {
    return frames.size() == round;
  }
}
