package domain.frame.status;

public abstract class LastBonusStatus implements FrameStatus {
    // 얘가 필요한 이유? 다음 보너스 부분 메세지 찍을 때 필요, 아니면 이전 Status라는걸 따로 만들까?
    /*private String regularMessage;
    private Score regularScore;*/

    LastBonusStatus() {

    }

    public static LastBonusStatus ofBonusReady() {
        return null;
    }
}
