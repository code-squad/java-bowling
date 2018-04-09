package bowling;

import bowling.domain.Player;
import bowling.view.Input;
import bowling.view.View;

public class Bowling {

    public static void main(String[] args) {
        String name = Input.inputName();
        Player player = new Player(name);
        int frameNum = 0;
        while (frameNum < 10) {
            int pin = Input.inputPinNumber();
            frameNum = player.playBowling(pin);
            View.numOfFrameView();
            View.scoreView(player);
        }
    }
}
