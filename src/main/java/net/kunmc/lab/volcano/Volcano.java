package net.kunmc.lab.volcano;

import dev.kotx.flylib.FlyLib;
import lombok.Getter;
import net.kunmc.lab.configlib.ConfigCommand;
import net.kunmc.lab.configlib.ConfigCommandBuilder;
import net.kunmc.lab.volcano.command.Main;
import net.kunmc.lab.volcano.config.Config;
import net.kunmc.lab.volcano.listener.ConfigListener;
import net.kunmc.lab.volcano.listener.VolcanoEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Volcano extends JavaPlugin {

    @Getter
    private static Volcano plugin;

    public Config config;

    @Override
    public void onEnable() {
        plugin = this;
        // Config
        config = new Config(this);
        config.saveConfigIfAbsent();
        config.loadConfig();

        // Event
        getServer().getPluginManager().registerEvents(new VolcanoEventListener(), plugin);

        // Command
        ConfigCommand configCommand = new ConfigCommandBuilder(config).build();

        FlyLib.create(this, builder -> {
            builder.command(new Main(configCommand));
        });

        ConfigListener.onModify();
    }

    @Override
    public void onDisable() {
    }
}
