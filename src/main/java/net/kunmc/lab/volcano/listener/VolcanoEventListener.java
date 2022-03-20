package net.kunmc.lab.volcano.listener;

import net.kunmc.lab.volcano.game.volcano.VolcanoTask;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

public class VolcanoEventListener implements Listener {
    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        VolcanoTask.addHardenBlockList(event.getBlock().getLocation());
    }
}