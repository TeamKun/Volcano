package net.kunmc.lab.volcano.game.volcano;

import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.util.Calc;
import org.bukkit.entity.Player;

/**
 * 火山の成長について管理するクラス
 */
public class VolcanoCreator {

    public static VolcanoAttribute createVolcano(Player player) {
        String world = player.getWorld().getName();

        System.out.println(Volcano.getPlugin().config.volcanoStartRange.value());
        int startX = (int) player.getLocation().getX() + Calc.getRangeRandomValue(Volcano.getPlugin().config.volcanoStartRange.value());
        int startZ = (int) player.getLocation().getZ() + Calc.getRangeRandomValue(Volcano.getPlugin().config.volcanoStartRange.value());

        System.out.println(startX + " " + startZ);
        return new VolcanoAttribute(startX, player.getWorld().getHighestBlockYAt(startX, startZ), startZ, world);
    }
}