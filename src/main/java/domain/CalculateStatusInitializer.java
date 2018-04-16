package domain;

public class CalculateStatusInitializer {

    public static boolean beforeFrameNotYetCase(Frame beforeFrame, Frame presentFrame) {
        if (beforeFrame.isStrike(0)) return changeStatusBeforeFrameNotYetAndStrike(presentFrame);
        return !beforeFrame.isSpare() || changeStatusBeforeFrameNotYetAndSpare(presentFrame);
    }

    public static boolean beforeFrameDoCase(Frame presentFrame) {
        if (!presentFrame.isTrySecond() && !presentFrame.isStrike(0)) {
            return false;
        }
        return presentFrame.isFrameEnd() && (!presentFrame.isSpare() && !presentFrame.isStrike(0));
    }

    private static boolean changeStatusBeforeFrameNotYetAndSpare(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) {
            return true;
        }
        return !presentFrame.isSpare();
    }

    private static boolean changeStatusBeforeFrameNotYetAndStrike(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) {
            return false;
        }
        if (presentFrame.isSpare()) return true;
        if (!presentFrame.isSpare() && !presentFrame.isStrike(0)) return true;
        return false;
    }

}

