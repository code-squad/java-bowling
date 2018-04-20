package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int NORMAL_FRAME = 9;
    private final int NAME_MIN = 2;
    private final int NAME_MAX = 4;

    private String name;
    private FrameData frameData = new FrameData();

    public Player(String name){
        if(name.length()<NAME_MIN||NAME_MAX<name.length()){
            throw new IllegalArgumentException("2~4자의 이름을 입력해주세요.");
        }
        this.name = name;
    }

    public boolean playBowling(int pin) {
        if (frameData.numberOfFrames() < NORMAL_FRAME) {
            frameData.play(pin);
            return false;
        }
       return frameData.playLastFrame(pin);
    }

    public int userFrameNumber(){
        return frameData.numberOfFrames()+1;
    }

    public FrameData getFrameData() {
        return frameData;
    }

    public String getName() {
        return name;
    }
}
