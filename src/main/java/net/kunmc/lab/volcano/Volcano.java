package net.kunmc.lab.volcano;

import lombok.Getter;
import net.kunmc.lab.volcano.game.volcano.VolcanoTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class Volcano extends JavaPlugin {

    @Getter
    private static Volcano plugin;

    @Override
    public void onEnable() {
        plugin = this;
        VolcanoTask.addVolcanoRunnable();
        VolcanoTask.putMagmaRunnable();
    }

    @Override
    public void onDisable() {
    }
}
