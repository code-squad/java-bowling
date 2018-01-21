package domain.state;

public enum BowlState {
  STRIKE(1),
  SPARE(2),
  MISS(2),
  GUTTER(2);

  private final int bowlTimes;

  BowlState(int bowlTimes) {
    this.bowlTimes = bowlTimes;
  }
}
