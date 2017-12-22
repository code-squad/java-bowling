package sangco.bowling.model;

import java.util.ArrayList;

import sangco.bowling.view.InputView;

public class UserList {
	private ArrayList<User> userList = new ArrayList<>();

	public UserList() {
		ArrayList<String> userNames = InputView.getUserList();
		for (String userName : userNames) {
			userList.add(new User(userName));
		}
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
}
