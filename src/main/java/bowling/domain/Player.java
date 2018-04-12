package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    static final int NAMESIZE = 3;
    static final int NOMALFRAME = 9;

    private String name;
    private FrameData frameData = new FrameData();

    public Player(String name) {
        if (name.length() != NAMESIZE) {
            throw new IllegalArgumentException("3자의 이름으로 입력 해주세요.");
        }
        this.name = name;
    }

    public boolean playBowling(int pin) {
        if (userFrameNum() <= NOMALFRAME) {
            frameData.play(pin);
            return false;
        }
        return frameData.playLastFrame(pin);
    }

    public String getName() {
        return name;
    }

    public int userFrameNum(){
        return frameData.numberOfFrame();
    }

    public List<NomalFrame> getFrames() {
        return frameData.getFrames();
    }

    public NomalFrame getNomalFrame() {
        return frameData.getNomalFrame();
    }

    public LastFrame getLastFrame() {
        return frameData.getLastFrame();
    }
}
