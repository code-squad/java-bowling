package bowling.domain;

import bowling.dto.FrameDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        this.frames  = new ArrayList<>();
        frames.add(new Frame());
    }

    public void marking(int no){
        Frame lastFrame = getLast();
        lastFrame.marking(no);

        if(!lastFrame.hasNext() && !isLast()){
            frames.add(getNext(frames.size()));
        }
    }

    public boolean isLast(){
        Frame lastFrame = getLast();
        if(lastFrame instanceof FinalFrame && !lastFrame.hasNext()){
            return true;
        }

        return false;
    }

    public List<FrameDTO> getResult(){
        List<FrameDTO> dtos = frames.stream()
                .map(f -> new FrameDTO(f.result()))
                .collect(Collectors.toList());

        for(int i=dtos.size() ; i<10 ; i++){
            dtos.add(new FrameDTO(""));
        }

        return dtos;
    }

    public int size(){
        return frames.size();
    }

    private Frame getLast(){
        return frames.get(frames.size()-1);
    }

    private Frame getNext(int term){
        if(term < 9){
            return new Frame();
        }

        return new FinalFrame();
    }

}
