import frame.Frame;
import game.Game;
import input.Input;
import view.ResultView;

import java.util.List;

public class Running {
    public static void main(String[] args) {
        String name = Input.inputName();
        Game game = new Game();
        for (int i = 1; i < 5; i++) {
            game.running(i);
        }

        ResultView.upperBar(game.getFrames(), name);

    }
}
