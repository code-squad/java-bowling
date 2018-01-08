package bowling;

import java.util.ArrayList;

public class BowlingGame {
	private static Frame bowl(Player player, Frame frame, ArrayList<Player> playerList) {
		player.frames.addFrame(frame);
		frame = takeInput(player, frame, playerList);
		return frame;
	}

	private static Frame takeInput(Player player, Frame frame, ArrayList<Player> playerList) {
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

	public static void playOneFrame(Player player, ArrayList<Player> playerList) {
		if (player.isNotStart()) {
			Frame frame = new NormalFrame(1);
			frame = bowl(player, frame, playerList);
			return;
		}

		Frame frame = player.frames.getLastFrame();
		frame = checkFrame(frame);
		frame = bowl(player, frame, playerList);
		return;
	}
	
	public static void playGame(ArrayList<Player> playerList) {
		for (Player player : playerList) {
			playOneFrame(player, playerList);
		}
	}

	//------------------MAIN START-------------------
	public static void main(String[] args) {
		ArrayList<Player> playerList = new ArrayList<Player> ();
		
		int peopleNo = InputView.howMany();
		for (int i = 0; i < peopleNo; i++) {
			//String playerName = InputView.inputName();
			Frames frames = new Frames();
			Player player = new Player(InputView.inputName(), frames);
			playerList.add(player);
		}
		
		ResultView.drawAllUserScore(playerList);
		while (playerList.get(playerList.size() - 1).isGameEnd()) {
			playGame(playerList);
		}
	}
}