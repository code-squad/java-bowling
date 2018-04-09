import domain.User;
import view.InputView;
import view.ResultView;

public class Main {

    static User user;


    public static void main(String[] args) {

        System.out.println("이름을 입력하세요.");
        user = User.of(InputView.getName());
        while (!user.roundEnd()) {
            System.out.println(String.format("%d프레임 투구", user.getFrameNumber()));
            userShotOnce(user);
            ResultView.printMenu();
            ResultView.printUserRoundState(user);
        }
    }

    private static void userShotOnce(User user) {
        try {
            user.shot(InputView.getNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("프레임 당 합쳐서 10을 넘길 수 없습니다.");
            userShotOnce(user);
        }
    }
}
