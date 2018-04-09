package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    static final int NAMESIZE = 3;
    private String name;
    private List<Frame> frames = new ArrayList<>();
    private Frame thisFrame = new Frame();
    ;

    public Player(String name) {
        if (name.length() != NAMESIZE) {
            throw new IllegalArgumentException("3자의 이름으로 입력 해주세요.");
        }
        this.name = name;
    }

    public int playBowling(int pin) {
        thisFrame.playOneBall(pin);
        if (thisFrame.isTwiceBall() || thisFrame.isStrike()) {  // 스트라이크나 한 프레임에 두번을 쳤을 때 다음 프레임으로 전환
            frames.add(thisFrame);
            thisFrame = Frame.next();
        }
        return frames.size();
    }

    public String getName() {
        return name;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public Frame getThisFrame() {
        return thisFrame;
    }
}
