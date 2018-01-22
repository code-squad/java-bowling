//package model;
//
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//public class FinalFrame extends Frame{
//    public FinalFrame() {
//        this.frameScores = IntStream.range(0, 3)
//                .mapToObj(i -> new Ball())
//                .collect(Collectors.toList());
//    }
//
//    public void setBallThree(int number) {
//
//        Ball thirdBall = frameScores.get(2);
//        thirdBall.setPinCount(number);
//    }
//
//    public boolean isAbleToPlay() {
//        Ball thirdBall = frameScores.get(2);
//
//        if(thirdBall.isPlayed())
//            return false;
//        if(isStrike())
//            return true;
//        if(isSpare())
//            return true;
//
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//
//        for(int i = 0; i < 3; i++) {
//            builder.append();
//        }
//
//        return builder.toString();
//    }
//}
