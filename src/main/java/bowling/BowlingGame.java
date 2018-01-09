package bowling;

import java.util.ArrayList;

public class BowlingGame {
	private static ArrayList<Player> playerList;
	
	private static Frame bowl(Player player, Frame frame) {
		player.frames.addFrame(frame);
		frame = takeInput(player, frame);
		return frame;
	}

	private static Frame takeInput(Player player, Frame frame) {
		while (frame.isNotEnd()) {
			frame.addScore(InputView.inputScore(player.name, frame));
			player.frames.updateFrames(frame);
			ResultView.drawAllUserScore(playerList);
		}
		return frame;
	}

	private static Frame checkFrame(Frame frame) {
		if (!frame.isNotEnd()) {
			return frame.addScore(0);
		}
		return frame;
	}

	public static void playOneFrame(Player player) {
		if (player.isNotStart()) {
			Frame frame = new NormalFrame(1);
			frame = bowl(player, frame);
			return;
		}

		Frame frame = player.frames.getLastFrame();
		frame = checkFrame(frame);
		frame = bowl(player, frame);
		return;
	}
	
	public static void playGame() {
		for (Player player : playerList) {
			playOneFrame(player);
		}
	}

	//------------------MAIN START-------------------
	public static void main(String[] args) {
		playerList = new ArrayList<Player> ();
		
		int peopleNo = InputView.howMany();
		for (int i = 0; i < peopleNo; i++) {
			Frames frames = new Frames();
			Player player = new Player(InputView.inputName(), frames);
			playerList.add(player);
		}
		
		ResultView.drawAllUserScore(playerList);
		while (playerList.get(playerList.size() - 1).isGameEnd()) {
			playGame();
		}
	}
}