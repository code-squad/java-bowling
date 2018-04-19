import domain.User;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        registerUser();
        playGame();
    }

    private static void registerUser() {
        System.out.println("How many people? ");
        int numPeople = InputView.getNumber();
        for (int i = 0; i < numPeople; i++) {
            System.out.println("유저 이름 입력해 주세요 : ");
            users.add(User.of(InputView.getName()));
        }
    }

    private static void playGame() {
        while (allUserEnd(users)) {
            usersPlay(users, 0);
        }
    }

    private static boolean allUserEnd(List<User> users) {
        return users.stream().noneMatch(User::roundEnd);
    }

    public static void usersPlay(List<User> users, int order) {
        System.out.printf("순서는 %d 번째 유저", order);
        User playUser = users.get(order);
        userShotOnce(playUser);
        viewAllUsers(users);
        if (playUser.tossNextTurn()) {
            System.out.println("이번 유저의 프레임은 끝이 났다.");
            order = nextOrder(users, order);
            usersPlay(users, order);
        }
        else {usersPlay(users, order);}
    }

    private static void userShotOnce(User user) {
        try {
            System.out.println(user.getName() + "의 턴 >>");
            user.shot(InputView.getNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("프레임 당 합쳐서 10을 넘길 수 없습니다!!");
            System.err.println(Arrays.toString(e.getStackTrace()));
            userShotOnce(user);
        }
    }

    public static void viewAllUsers(List<User> users) {
        ResultView.printMenu();
        users.forEach(ResultView::printUserRoundState);
    }

    private static int nextOrder(List<User> users, int order) {
        order++;
        if (order == users.size()) {
            order = 0;
        }
        return order;
    }

}
