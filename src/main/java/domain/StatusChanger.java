package domain;

public class StatusChanger {

    public static boolean beforeFrameDoNotCase(Frame beforeFrame, Frame presentFrame) {
        if (beforeFrame.isFirstStrike()) return changeStatusBeforeFrameDoNotAndStrike(presentFrame);
        return !beforeFrame.isSpare() || changeStatusBeforeFrameDoNotAndSpare(presentFrame);
    }

    private static boolean changeStatusBeforeFrameDoNotAndSpare(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) {
            return !presentFrame.isFirstStrike();
        }
        return !presentFrame.isSpare();
    }

    private static boolean changeStatusBeforeFrameDoNotAndStrike(Frame presentFrame) {
        if (!presentFrame.isTrySecond()) {
            return !presentFrame.isFirstStrike();
        }
        if (presentFrame.isSpare()) return false;
        if (!presentFrame.isSpare() && !presentFrame.isFirstStrike()) return true;
        return true;
    }

    public static boolean beforeFrameDoCase(Frame presentFrame) {
        if (!presentFrame.isTrySecond() && !presentFrame.isFirstStrike()) {
            return true;
        }
        return presentFrame.isFrameEnd() && (!presentFrame.isSpare() && !presentFrame.isFirstStrike());
    }
}

