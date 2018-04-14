package domain;

public class StatusChanger {

    public static boolean beforeFrameDoNotCase(Frame beforeFrame, Frame presentFrame) {
        if (beforeFrame.isFirstStrike()) return changeStatusBeforeFrameDoNotAndStrike(presentFrame);
        return !beforeFrame.isSpare() || changeStatusBeforeFrameDoNotAndSpare(presentFrame);
    }

    public static boolean beforeFrameDoCase(Frame presentFrame) {
        if (!presentFrame.isTrySecond() && !presentFrame.isFirstStrike()) {
            return false;
        }
        return presentFrame.isFrameEnd() && (!presentFrame.isSpare() && !presentFrame.isFirstStrike());
    }

    private static boolean changeStatusBeforeFrameDoNotAndSpare(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) {
            return true;
        }
        return !presentFrame.isSpare();
    }

    private static boolean changeStatusBeforeFrameDoNotAndStrike(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) {
            return false;
        }
        if (presentFrame.isSpare()) return true;
        if (!presentFrame.isSpare() && !presentFrame.isFirstStrike()) return true;
        return false;
    }

}

