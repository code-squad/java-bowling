package bowling;

import bowling.domain.BowlingUser;
import bowling.domain.Game;
import bowling.view.Input;
import bowling.view.View;

public class Main {

    public static void main(String[] args) {
        Input input = Input.generate(System.in);
        Game game = Game.generate(BowlingUser.registed(input.getName()));

        View view = new View(game, input);
        view.rendering();
    }
}
