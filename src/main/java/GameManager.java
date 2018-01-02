import java.util.ArrayList;
import java.util.Arrays;

import sangco.bowling.model.User;
import sangco.bowling.model.UserList;
import sangco.bowling.view.InputView;

public class GameManager {
	private UserList userList = new UserList();
	private boolean nextFrame = false;
	private int firstRoll = 0;
	private int frame = 0;
	
	
	public void getInputUserNames(String inputUserNames) {
		userList.createUsers(new ArrayList<>(Arrays.asList(inputUserNames.split(","))));
	}
	
	public void getInputScore (int inputScore) {
		nextFrame = getScoreInformation(inputScore);
	}
	
	public boolean getScoreInformation(int inputScore) {
		if(inputScore == 10) {
			creatEachFrame(inputScore, 0);
			return false;
		}
		if(nextFrame == true) {
			creatEachFrame(firstRoll, inputScore);
			return false;
		}
		firstRoll = inputScore;
		return true;
	}
	
	
	public void notStrikeFrame(int roll) {
		firstRoll = roll;
	}
	
	
	
	
	
	
	private void creatEachFrame(int firstRoll, int secondRoll) {
	}
	
/*		
		for (int i = 1; i <= 10; i++) {
			for (User user : userList.getUserList()) {
				user.getBoard().createFrame(i, InputView.getScore());
			}
		}*/
	


}
