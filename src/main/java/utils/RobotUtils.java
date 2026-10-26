package utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {
    private static final int WINDOW_OPEN_DELAY_MS = 1000;
    private static final int PASTE_DELAY_MS = 500;
    private static final int WINDOW_CLOSE_DELAY_MS = 500;

    private RobotUtils() {
    }

    public static void uploadFile(String absolutePath) {
        StringSelection selection = new StringSelection(absolutePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        try {
            Robot robot = new Robot();
            robot.delay(WINDOW_OPEN_DELAY_MS);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(PASTE_DELAY_MS);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.delay(WINDOW_CLOSE_DELAY_MS);
        } catch (Exception e) {
            throw new RuntimeException("Unable to upload the file via Robot", e);
        }
    }
}