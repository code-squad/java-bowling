import frame.Frame;
import game.Game;
import input.Input;

import java.util.List;

public class Running {
    public static void main(String[] args) {
        String name = Input.inputName();
        Game game = new Game();
        for (int i = 1; i < 5; i++) {
            game.running(i);
        }

        System.out.println("player name is " + name);
        for (Frame frame : game.getFrames()) {
            System.out.println("firstPin value is " + frame.getFirstPin().getPinFall());
        }
    }
}
