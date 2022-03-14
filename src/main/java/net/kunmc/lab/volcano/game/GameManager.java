package net.kunmc.lab.volcano.game;

import org.bukkit.entity.Player;

public class GameManager {
    public static GameMode runningMode = GameMode.MODE_NEUTRAL;


    public static void controller(GameMode runningMode, Player p) {
        GameManager.runningMode = runningMode;

        switch (runningMode) {
            case MODE_START:
                break;
            case MODE_NEUTRAL:
                break;
            case MODE_PAUSE:
                break;
        }
    }

    public enum GameMode {
        MODE_START,
        MODE_NEUTRAL,
        MODE_PAUSE
    }

    public static boolean isRunning() {
        return runningMode == GameMode.MODE_START;
    }

    public static boolean isPause() {
        return runningMode == GameMode.MODE_PAUSE;
    }
}
