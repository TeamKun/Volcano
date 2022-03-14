package net.kunmc.lab.volcano.game.volcano;

import net.kunmc.lab.volcano.util.Calc;
import org.bukkit.entity.Player;

/**
 * 火山の成長について管理するクラス
 */
public class VolcanoCreator {

    public static VolcanoAttribute createVolcano(Player player) {
        String world = player.getWorld().getName();

        int startX = (int) player.getLocation().getX() + Calc.getRangeRandomValue(15);
        int startZ = (int) player.getLocation().getZ() + Calc.getRangeRandomValue(15);

        return new VolcanoAttribute(startX, player.getWorld().getHighestBlockYAt(startX, startZ), startZ, world);
    }
}