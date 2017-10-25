package bowling.model;

import bowling.model.frame.Frame;
import bowling.model.frame.NormalFrame;

public class Player {
	private String name;
	private Frame first;
	private Frame now;
	private Frame before;
	private Result result;

	public Player(String name) {
		this.name = name;
		this.first = new NormalFrame(1);
		this.now = first;
		this.result = new Result();
	}

	public String getName() {
		return name;
	}

	public boolean bowl(int knockedPins) {
		before = now;
		now = now.bowl(knockedPins);
		calculate();
		updateResult();
		return checkEndState();
	}

	private boolean checkEndState() {
		return before.isEndState();
	}

	public void updateResult() {
		result.updateKnockedPins(before.getNo(), before.getKnockedPins());
	}

	public int getNowNo() {
		return now.getNo();
	}

	public String getScore() {
		return first.getSumScore();
	}

	public void calculate() {
		while (first.calculate(0)) {
			result.updateSumScores(first.getSumScore());
		}
	}

	public Result getResult() {
		return result;
	}

}
