package net.kunmc.lab.volcano.game.volcano;

import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.util.Calc;
import org.bukkit.Bukkit;

/**
 * 火山の成長について管理するクラス
 */
public class VolcanoCreator {

    public static VolcanoAttribute createVolcano() {
        int startX = (int) Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value().getX() +
                Calc.getRangeRandomValue(Volcano.getPlugin().config.volcanoStartRange.value());
        int startZ = (int) Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value().getZ() +
                Calc.getRangeRandomValue(Volcano.getPlugin().config.volcanoStartRange.value());

        String world = Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value().getWorld().getName();
        return new VolcanoAttribute(startX, Bukkit.getWorld(world).getHighestBlockYAt(startX, startZ), startZ, world);
    }
}