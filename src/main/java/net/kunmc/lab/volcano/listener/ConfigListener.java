package net.kunmc.lab.volcano.listener;

import net.kunmc.lab.configlib.value.IntegerValue;
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
        Volcano.getPlugin().config.volcanoType.onModify(x -> {
            if (x.equals("demonstration")) {
                Volcano.getPlugin().config.volcanoNum = new IntegerValue(1);
                Volcano.getPlugin().config.putLavaNum = new IntegerValue(3);
                Volcano.getPlugin().config.volcanoHeight = new IntegerValue(80);
                Volcano.getPlugin().config.volcanoWeight = new IntegerValue(80);
                Volcano.getPlugin().config.volcanoGrowTick = new IntegerValue(120);
                Volcano.getPlugin().config.putLavaTick = new IntegerValue(150);
            } else if (x.equals("normal")) {
                Volcano.getPlugin().config.volcanoNum = new IntegerValue(8);
                Volcano.getPlugin().config.putLavaNum = new IntegerValue(3);
                Volcano.getPlugin().config.volcanoHeight = new IntegerValue(80);
                Volcano.getPlugin().config.volcanoWeight = new IntegerValue(80);
                Volcano.getPlugin().config.volcanoGrowTick = new IntegerValue(120);
                Volcano.getPlugin().config.putLavaTick = new IntegerValue(150);
            } else if (x.equals("hard")) {
                Volcano.getPlugin().config.volcanoNum = new IntegerValue(15);
                Volcano.getPlugin().config.putLavaNum = new IntegerValue(6);
                Volcano.getPlugin().config.volcanoHeight = new IntegerValue(40);
                Volcano.getPlugin().config.volcanoWeight = new IntegerValue(40);
                Volcano.getPlugin().config.volcanoGrowTick = new IntegerValue(60);
                Volcano.getPlugin().config.putLavaTick = new IntegerValue(150);
            }
        });
    }
}