package net.kunmc.lab.volcano.game.volcano;

import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.config.ConfigConst;
import net.kunmc.lab.volcano.util.Calc;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import static net.kunmc.lab.volcano.util.Calc.random;

/**
 * 火山の成長について管理するクラス
 */
public class VolcanoCreator {

    public static VolcanoAttribute createVolcano() {
        int[] point = getCreateVolcanoPoint();

        if (point == null) return null;

        int startX = point[0] + Calc.getRangeRandomValue(Volcano.getPlugin().config.volcanoStartRange.value());
        int startZ = point[1] + Calc.getRangeRandomValue(Volcano.getPlugin().config.volcanoStartRange.value());

        String world = Volcano.getPlugin().config.volcanoWorld.value();
        return new VolcanoAttribute(startX, Bukkit.getWorld(world).getHighestBlockYAt(startX, startZ), startZ, world);
    }

    private static int[] getCreateVolcanoPoint() {
        if (Volcano.getPlugin().config.createVolcanoType.value().equals(ConfigConst.CREATE_VOLCANO_TYPE_PLAYER)) {
            Object[] players = getTargetPlayers();
            if (players.length == 0) return null;
            Player player = (Player) players[random.nextInt(players.length)];
            return new int[]{(int) player.getLocation().getX(), (int) player.getLocation().getZ()};
        } else {
            int x = Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value().left;
            int z = Volcano.getPlugin().config.createVolcanoPointOnCoordinate.value().right;
            return new int[]{x, z};
        }
    }

    private static Object[] getTargetPlayers() {
        return Bukkit.getOnlinePlayers().stream().filter(x -> !x.getGameMode().equals(GameMode.SPECTATOR) &&
                !x.getGameMode().equals(GameMode.CREATIVE) &&
                !x.isDead()).toArray();
    }
}