package bowling;

import java.util.Random;

public class Play {
	//볼을 굴린다. 시도 횟수 별로 나눈다.
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
	//첫 투구 볼 굴리기.
	private static void firstThrow(Status playerStatus) {
		Random random = new Random();
		int totalPin = playerStatus.getFrame().getPinNum();
		
		int throwScore = random.nextInt(totalPin + 1);
		
		System.out.println((playerStatus.getFrame().getFrameNum() + 1) + "프레임 투구.");
		System.out.println("초구 던집니다. " + throwScore + "개 넘어뜨렸네요.");
		playerStatus.getFrame().updatePin(throwScore);
		playerStatus.getScore().updateFrameScore(throwScore);
		playerStatus.getScore().updateFirstAccRec(playerStatus.getFrame().getFrameNum());
	}
	//스페어 처리 (2번째 투구).
	private static void spareThrow(Status playerStatus) {
		Random random = new Random();
		int totalPin = playerStatus.getFrame().getPinNum();
		
		int throwScore = random.nextInt(totalPin + 1);
		
		System.out.println("스페어 처리 던집니다. " + throwScore + "개 넘어뜨렸네요.");
		playerStatus.getFrame().updatePin(throwScore);
		playerStatus.getScore().updateFrameScore(throwScore);
		playerStatus.getScore().updateSecondAccRec(playerStatus.getFrame());
	}
	//핀이 몇 개 남았는지를 이용해 상태값 초기화 / 시도횟수 증가.
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