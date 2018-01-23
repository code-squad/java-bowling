package domain.state;

public enum BowlState {
  STRIKE("X"),
  SPARE("/"),
  GUTTER("-");

  private String symbol;

  public String getSymbol() {
    return symbol;
  }

  private BowlState(String symbol) {
    this.symbol = symbol;
  }

}
