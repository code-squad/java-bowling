package sangco.bowling.model;

import java.util.ArrayList;

import sangco.bowling.view.InputView;

public class UserList {
	private ArrayList<User> userList = new ArrayList<>();

	public ArrayList<User> getUserList() {
		return userList;
	}
	
	public void createUsers(ArrayList<String> userNames) {
		for (String userName : userNames) {
			userList.add(new User(userName));
		}
	}
}
