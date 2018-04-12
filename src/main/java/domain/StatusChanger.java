package domain;

import static domain.CalculateStatus.DO;
import static domain.CalculateStatus.DONOT;

public class StatusChanger {

    public static CalculateStatus beforeFrameDoNotCase(Frame beforeFrame, Frame presentFrame) {
        if (beforeFrame.isFirstStrike()) return changeStatusBeforeFrameDoNotAndStrike(presentFrame);
        if (beforeFrame.isSpare()) return changeStatusBeforeFrameDoNotAndSpare(presentFrame);
        return null;
    }

    private static CalculateStatus changeStatusBeforeFrameDoNotAndSpare(Frame presentFrame) {
        if (!presentFrame.isTrySecond() && presentFrame.isFirstStrike()) return DONOT;
        if (!presentFrame.isTrySecond() && !presentFrame.isFirstStrike()) return DO;
        if (presentFrame.isSpare()) return DONOT;
        return DO;
    }

    private static CalculateStatus changeStatusBeforeFrameDoNotAndStrike(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) return DONOT;
        if (!presentFrame.isTrySecond() && !presentFrame.isFirstStrike()) return DO;
        if (presentFrame.isSpare()) return DONOT;
        if (!presentFrame.isSpare() && !presentFrame.isFirstStrike()) return DO;
        return null;
    }

    public static CalculateStatus beforeFrameDoCase(Frame presentFrame) {
        if (!presentFrame.isTrySecond() && !presentFrame.isFirstStrike()) {
            return DO;
        }
        if (presentFrame.isFrameEnd() && (!presentFrame.isSpare() && !presentFrame.isFirstStrike())) {
            return DO;
        }
        return DONOT;
    }
}

