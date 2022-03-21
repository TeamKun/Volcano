package net.kunmc.lab.volcano.listener;

import net.kunmc.lab.volcano.Volcano;
import net.kunmc.lab.volcano.game.volcano.VolcanoAttribute;
import net.kunmc.lab.volcano.game.volcano.VolcanoTask;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class VolcanoEventListener implements Listener {
    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        // 火山の範囲にいるマグマのみを石に変える
        // 厳密な変更にはならないが大体の挙動ができていればよい

        if (!event.getBlock().getType().equals(Material.LAVA)) return;

        for (VolcanoAttribute volcano : VolcanoTask.volcanoList) {
            int minWidthX = volcano.getPointX() - Volcano.getPlugin().config.volcanoWeight.value();
            int maxWidthX = volcano.getPointX() + Volcano.getPlugin().config.volcanoWeight.value();
            int minWidthZ = volcano.getPointZ() - Volcano.getPlugin().config.volcanoWeight.value();
            int maxWidthZ = volcano.getPointZ() + Volcano.getPlugin().config.volcanoWeight.value();
            int pointX = event.getBlock().getX();
            int pointZ = event.getBlock().getZ();
            if (minWidthX <= pointX && pointX <= maxWidthX && minWidthZ <= pointZ && pointZ <= maxWidthZ) {
                VolcanoTask.addHardenBlockList(event.getBlock().getLocation());
            }
        }
    }
}