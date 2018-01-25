package domain;

public class FrameResult {

  private String result;

  public FrameResult() {}

  public void setResult(String result) {
    this.result = result;
  }

  public String getResult() {
    return result != null ? result : "";
  }
}
