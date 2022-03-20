package net.kunmc.lab.volcano.game;

import net.kunmc.lab.volcano.game.volcano.VolcanoTask;

public class GameManager {
    public static GameMode runningMode = GameMode.MODE_NEUTRAL;


    public static void controller(GameMode runningMode) {
        GameManager.runningMode = runningMode;

        switch (runningMode) {
            case MODE_START:
                VolcanoTask.startVolcanoTasks();
                break;
            case MODE_NEUTRAL:
                VolcanoTask.stopVolcanoTask();
                break;
        }
    }

    public enum GameMode {
        MODE_START,
        MODE_NEUTRAL
    }

    public static boolean isRunning() {
        return runningMode == GameMode.MODE_START;
    }
}
