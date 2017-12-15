package bowling;

import java.util.Random;

public class Play {
	public static void throwBall(Status playerStatus) {
		if (playerStatus.getFrame().getTryNum() == 1) {
			firstThrow(playerStatus);
			checkPin(playerStatus);
			return;
		}
		spareThrow(playerStatus);
		playerStatus.getFrame().goNextFrame();
		return;
	}
	
	private static void firstThrow(Status playerStatus) {
		Random random = new Random();
		int totalPin = playerStatus.getFrame().getPinNum();
		
		int throwScore = random.nextInt(totalPin + 1);
		
		System.out.println(playerStatus.getFrame().getFrameNum() + "프레임 투구.");
		System.out.println("초구 던집니다. " + throwScore + "개 넘어뜨렸네요.");
		playerStatus.getFrame().updatePin(throwScore);
		playerStatus.getScore().updateFrameScore(throwScore);
		playerStatus.getScore().updateFirstAccRec(playerStatus.getFrame().getFrameNum());
	}
	
	private static void spareThrow(Status playerStatus) {
		Random random = new Random();
		int totalPin = playerStatus.getFrame().getPinNum();
		
		int throwScore = random.nextInt(totalPin + 1);
		
		System.out.println("스페어 처리 던집니다. " + throwScore + "개 넘어뜨렸네요.");
		playerStatus.getFrame().updatePin(throwScore);
		playerStatus.getScore().updateFrameScore(throwScore);
		playerStatus.getScore().updateSecondAccRec(playerStatus.getFrame());
	}
	
	private static void checkPin(Status playerStatus) {
		if (playerStatus.getFrame().isSpare()) {
			playerStatus.getFrame().clearTryNum();
			playerStatus.getFrame().clearPin();
			playerStatus.getFrame().goNextFrame();
			return;
		}
		playerStatus.getScore().readySecondShot(playerStatus.getFrame().getFrameNum());
		playerStatus.getFrame().addTryNum();
		return;
	}

}


//public void updateScore(int score, Frame frame) {
//	if (frame.getTryNum() == 1) {
//		frame.updatePin(score);
//		updateFrameScore(score);
//		updateFirstAccRec(frame.getFrameNum());
//		frame.addTryNum();
//		return;
//	}
//	frame.updatePin(score);
//	updateFrameScore(score);
//	readySecondShot(frame.getFrameNum());
//	updateSecondAccRec(frame);
//	frame.clearTryNum();
//}