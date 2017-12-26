package sangco.bowling.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sangco.bowling.view.InputView;

public class TestUserList {
private UserList userList;
	
	@Before
	public void setup() {
		userList = new UserList();

		for (int i = 1; i <= 10; i++) {
			for (User user : userList.getUserList()) {
				user.getBoard().createFrame(i, InputView.getScore());
			}
		}
	}
	
	@Test
	public void test_createUserList() {
		assertEquals(3, userList.getUserList().size());
	}
	@Test
	public void test_checkUsersTotalFrameSize() {
		assertEquals(30, eachUserFrameSize(0) + eachUserFrameSize(1) + eachUserFrameSize(2));
	}
	
	private int eachUserFrameSize(int userIndex) {
		return userList.getUserList().get(userIndex).getBoard().scoreBoard.size();
	}
}
