package net.kunmc.lab.volcano.listener;

import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.game.volcano.VolcanoTask;

public class ConfigListener {
    public static void onModify() {
        Volcano.getPlugin().config.putLavaTick.onModify(x -> {
            VolcanoTask.restartTask("putLavaTick");
        });
        Volcano.getPlugin().config.volcanoGrowTick.onModify(x -> {
            VolcanoTask.restartTask("growVolcanoTick");
        });
    }
}
