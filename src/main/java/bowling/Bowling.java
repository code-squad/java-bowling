package bowling;

import bowling.domain.Player;
import bowling.view.Input;
import bowling.view.View;
//import bowling.view.View;

public class Bowling {

    public static void main(String[] args) {
        String name = Input.inputName();
        Player player = new Player(name);
        boolean isLast = false;
        while (!isLast) {
            int frameNum = player.userFrameNumber();
            int pin = Input.inputPinNumber(frameNum);
            isLast = player.playBowling(pin);
            View.numberOfFrameView();
            View.framePrint(player);
        }
    }
}
