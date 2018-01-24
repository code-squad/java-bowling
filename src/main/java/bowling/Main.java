package bowling;

import bowling.domain.BowlingUser;
import bowling.view.GameView;
import bowling.view.Input;
import bowling.view.View;

public class Main {

    public static void main(String[] args) {
        Input input = Input.generate(System.in);
        GameView gameView = GameView.generate(BowlingUser.registed(input.getName()));

        View view = new View(gameView, input);
        view.rendering();
    }
}
