package bowling.utils;

import bowling.exception.BowlingGameException;

public class UtilsNumber {

	private int playerCount;

	public void setPlayerCount(int playerCount) {
		try {
			if (playerCount < 0 || playerCount > Integer.MAX_VALUE) {
				throw new BowlingGameException("플레이어의 수는 음수가 되거나 " + Integer.MAX_VALUE + " 보다 클 수 없습니다.");
			}
		} catch (BowlingGameException e) {
			e.printStackTrace();
		} finally {
			this.playerCount = 0;
		}
		this.playerCount = playerCount;
	}

	public int getPlayerCount() {
		return playerCount;
	}

}
